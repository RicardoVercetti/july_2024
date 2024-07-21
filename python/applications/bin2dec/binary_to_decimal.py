import math

# n's binary value would be n divided by 2 result is divided futher until it becomes 0 or 1, 
# reminder is taken and compiled for binary
def dec_to_bin(num):
    # until it reduces to 0
    binary = ""
    target_num = num
    while(target_num != 0 and target_num != 1):
        result = math.floor(target_num/2)
        reminder = target_num % 2
        binary += str(reminder)
        target_num = result
        
        if(target_num == 0):
            binary += str(0)
        elif(target_num == 1):
            binary += str(1)
        else:
            pass
        
        # print("===============================")
        # print(f"Num {target_num}")
        # print(f"Rem : {reminder}")
        # print(f"result : {result}")
        # print("===============================")
        
    # print(f"Final binary value : {binary}")
    # print(f"Input text : {num}")
    
    # reverse it so that the least and most significant bytes
    returnable = ""
    for char in reversed(binary):
        returnable+=char
    
    return returnable



def bin_to_dec(bin: str):
    return_value = 0
    for char in len(bin):
        1 * 2 ** char
    return return_value




# print("Runs...")
# returned = dec_to_bin(195)
# returned = bin_to_dec("1101")
# print("Returned : ", returned)