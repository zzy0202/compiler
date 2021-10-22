grammar lab2;

WhiteSpace                  : [ \t\n\r] -> skip;
DecimalConst                : NonzeroDigit DecimalConst_;
fragment DecimalConst_      : (Digit DecimalConst_)?;

OctalConst                  : '0' OctalConst_;
fragment OctalConst_        : (OctalDigit OctalConst_)?;

HexadecimalConst            : HexadecimalPrefix HexadecimalDigit HexadecimalConst_;
fragment HexadecimalConst_  : (HexadecimalDigit HexadecimalConst_)?;


HexadecimalPrefix : '0x' | '0X';
NonzeroDigit      : '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9';
OctalDigit        : '0' | '1' | '2' | '3' | '4' | '5' | '6' | '7';
Digit             : '0' | NonzeroDigit;
HexadecimalDigit  : '0' | '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9'
                      | 'a' | 'b' | 'c' | 'd' | 'e' | 'f'
                      | 'A' | 'B' | 'C' | 'D' | 'E' | 'F';
Add               : '+';
Sub               : '-';
Mult              : '*';
Div               : '/';
Mod               : '%';

//grammar rules
compUnit    : funcDef;
funcDef     : funcType ident '(' ')' block;
funcType    : 'int';
ident       : 'main';
block       : '{' stmt '}';
stmt        : 'return' exp ';';
exp         : addExp;
addExp      : mulExp | addExp (Add | Sub ) mulExp;
mulExp      : unaryExp | mulExp (Mult | Div | Mod) unaryExp;
unaryExp    : primaryExp | unaryOp unaryExp;
primaryExp  : '(' exp ')' | number;
unaryOp     : Add | Sub;
number      : DecimalConst | OctalConst | HexadecimalConst;
