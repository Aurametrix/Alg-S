object LogoParser extends RegexParsers {
   
    def positiveInteger = """\d+"""r
    
    def forward = ("FD"|"FORWARD")~positiveInteger 
    
    def right = ("RT"|"RIGHT")~positiveInteger 
    
    def left = ("LT"|"LEFT")~positiveInteger 
                                               
    def repeat = "REPEAT" ~ positiveInteger ~ "[" ~ rep(statement) ~ "]" 
        
    def statement:Parser[Any] = forward | right | left | repeat

    def program = rep(statement)
}

