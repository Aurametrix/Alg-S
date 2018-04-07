package com.twitter.storehaus

import com.twitter.util.{ Closable, Future, Time }

trait ReadableStore[-K, +V] extends Closeable {
  def get(k: K): Future[Option[V]]
  def multiGet[K1 <: K](ks: Set[K1]): Map[K1, Future[Option[V]]]
  override def close(time: Time) = Future.Unit
}

trait WritableStore[-K, -V] {
  def put(kv: (K, V)): Future[Unit] = multiPut(Map(kv)).apply(kv._1)
  def multiPut[K1 <: K](kvs: Map[K1, V]): Map[K1, Future[Unit]] =
    kvs.map { kv => (kv._1, put(kv)) }
  override def close(time: Time) = Future.Unit
}

trait Store[-K, V] extends ReadableStore[K, V] with WritableStore[K, Option[V]]
