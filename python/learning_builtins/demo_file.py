# demo_file.py

class NewData:
	def __init__(self):
		pass

	def __str__(self):
		return "NewData"

n1 = NewData()
n2 = NewData()

my_dict = {'name': 'John', 'age': 25, True: "nothing", n1: "data 1"}

# my_dict.clear()

del my_dict["name"]

print(my_dict.get("name"))
print(my_dict)