# data_types_intro.py
import math


# builtin data types

# Text Type: 	str
# Numeric Types: 	int, float, complex
# Sequence Types: 	list, tuple, range
# Mapping Type: 	dict
# Set Types: 	set, frozenset
# Boolean Type: 	bool
# Binary Types: 	bytes, bytearray, memoryview
# None Type: 	NoneType

# x = str("Hello World") 	                    str 	
# x = int(20) 	                                int 	
# x = float(20.5) 	                            float 	
# x = complex(1j) 	                            complex 	
# x = list(("apple", "banana", "cherry")) 	    list 	
# x = tuple(("apple", "banana", "cherry")) 	    tuple 	
# x = range(6) 	                                range 	
# x = dict(name="John", age=36) 	            dict 	
# x = set(("apple", "banana", "cherry")) 	    set 	
# x = frozenset(("apple", "banana", "cherry")) 	frozenset 	
# x = bool(5) 	                                bool 	
# x = bytes(5) 	                                bytes 	
# x = bytearray(5)  	                        bytearray 	
# x = memoryview(bytes(5)) 	                    memoryview


# 1. Basic Data Types:
# Integers (int):

#     Whole numbers without a decimal point.
#     Examples: 0, -5, 42

# Floating-Point Numbers (float):

#     Numbers with a decimal point.
#     Examples: 3.14, -0.001, 2.0

# Complex Numbers (complex):

#     Numbers with a real and an imaginary part.
#     Examples: 3 + 4j, 1 - 2j

# 2. Basic Operations:
# Arithmetic Operations:

# Addition: +
# a = 5 + 3  # 8

# Subtraction: -
# b = 5 - 3  # 2

# Multiplication: *
# c = 5 * 3  # 15

# Division: /
# d = 5 / 3  # 1.6666666666666667

# Floor Division: //
# e = 5 // 3  # 1

# Modulus: %
# f = 5 % 3  # 2

# Exponentiation: **
# g = 5 ** 3  # 125


# Type-Specific Methods:

# Integers (int):
# bit_length(): Returns the number of bits necessary to represent an integer in binary.

# n = 10
# n.bit_length()  # 4

# to_bytes(length, byteorder): Returns an array of bytes representing an integer.
# n = 1024
# n.to_bytes(2, byteorder='big')  # b'\x04\x00'

# Floating-Point Numbers (float):
# is_integer(): Returns True if the float is an integer.

# f = 2.0
# f.is_integer()  # True

# hex(): Returns a hexadecimal string representing a float.

# f = 2.0
# f.hex()  # '0x1.0000000000000p+1'

# Complex Numbers (complex):
# real: Returns the real part of the complex number.
# c = 3 + 4j
# c.real  # 3.0

# imag: Returns the imaginary part of the complex number.
# c = 3 + 4j
# c.imag  # 4.0

# conjugate(): Returns the complex conjugate
# c = 3 + 4j
# c.conjugate()  # (3-4j)

# Advanced Operations:

# Built-in Functions:
# abs(x): Returns the absolute value of a number.
# abs(-5)  # 5
# abs(3 + 4j)  # 5.0

# round(x, n): Rounds a number to n decimal places.
# round(3.14159, 2)  # 3.14

# pow(x, y): Returns x raised to the power y.
# pow(2, 3)  # 8

# divmod(x, y): Returns a tuple containing the quotient and remainder.
# divmod(5, 3)  # (1, 2)

# Mathematical Functions (from the math module):

# math.sqrt(x): Returns the square root of x.
# math.sqrt(16)  # 4.0

# math.exp(x): Returns e raised to the power x.
# math.exp(2)  # 7.38905609893065

# math.log(x, base): Returns the logarithm of x to the given base.
# math.log(8, 2)  # 3.0

# math.sin(x), math.cos(x), math.tan(x): Returns the trigonometric functions of x.
# math.sin(math.pi / 2)  # 1.0



print(c.imag)


