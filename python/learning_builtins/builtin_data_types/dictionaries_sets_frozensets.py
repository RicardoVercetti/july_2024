# dictionaries_sets_frozensets.py

# 1. Dictionaries
# A dictionary in Python is an unordered collection of items. Each item is a key-value pair.
# -------------------------------------------------------
# Creating Dictionaries:
# # Empty dictionary
# my_dict = {}

# # Dictionary with integer keys
# my_dict = {1: 'apple', 2: 'ball'}

# # Dictionary with mixed keys
# my_dict = {'name': 'John', 1: [2, 4, 3]}

# # Using dict() function
# my_dict = dict({1: 'apple', 2: 'ball'})

# # Using dict() with keyword arguments
# my_dict = dict(name='John', age=25)
# -------------------------------------------------------
# Accessing Values:
# my_dict = {'name': 'John', 'age': 25}

# # Accessing value using key
# print(my_dict['name'])  # John

# # Using get() method
# print(my_dict.get('age'))  # 25
# -------------------------------------------------------
# Modifying Dictionaries:
# my_dict = {'name': 'John', 'age': 25}

# # Adding a new key-value pair
# my_dict['address'] = 'New York'

# # Updating an existing key-value pair
# my_dict['age'] = 26

# # Removing a key-value pair using pop()
# my_dict.pop('address')

# # Removing a key-value pair using del
# del my_dict['name']

# # Removing all items
# my_dict.clear()

# # Deleting the dictionary
# del my_dict
# -------------------------------------------------------
# Dictionary Methods:
# my_dict = {'name': 'John', 'age': 25, 'address': 'New York'}

# # copy() - Returns a shallow copy of the dictionary
# new_dict = my_dict.copy()

# # fromkeys(seq[, v]) - Creates a new dictionary with keys from seq and values set to v (default is None)
# keys = {'a', 'e', 'i', 'o', 'u'}
# vowels_dict = dict.fromkeys(keys, 'vowel')

# # get(key[, default]) - Returns the value for key if key is in the dictionary, else default
# value = my_dict.get('name', 'Default Name')

# # items() - Returns a new view of the dictionary’s items (key, value)
# items = my_dict.items()

# # keys() - Returns a new view of the dictionary’s keys
# keys = my_dict.keys()

# # pop(key[, default]) - Removes and returns the value for key if key is in the dictionary
# age = my_dict.pop('age', 'Key not found')

# # popitem() - Removes and returns an arbitrary (key, value) pair
# item = my_dict.popitem()

# # setdefault(key[, default]) - If key is in the dictionary, return its value. If not, insert key with a value of default and return default
# value = my_dict.setdefault('age', 26)

# # update([other]) - Updates the dictionary with the key/value pairs from other, overwriting existing keys
# my_dict.update({'age': 27, 'city': 'Boston'})

# # values() - Returns a new view of the dictionary’s values
# values = my_dict.values()
# -------------------------------------------------------

# 2. Sets
# A set is an unordered collection of unique items. Sets are mutable 
# and can be used to perform mathematical set operations like union, intersection, difference, etc.

# Creating Sets:
# # Empty set
# my_set = set()

# # Set with elements
# my_set = {1, 2, 3}

# # Using set() function
# my_set = set([1, 2, 3, 4])
# -------------------------------------------------------
# Modifying Sets:
# my_set = {1, 2, 3}

# # Adding an element
# my_set.add(4)

# # Adding multiple elements
# my_set.update([4, 5, 6])

# # Removing an element
# my_set.remove(3)  # Raises KeyError if not found

# # Removing an element using discard()
# my_set.discard(4)  # Does not raise KeyError

# # Removing an arbitrary element
# my_set.pop()

# # Clearing the set
# my_set.clear()
# -------------------------------------------------------
# Set Methods:
# my_set = {1, 2, 3, 4, 5}

# # copy() - Returns a shallow copy of the set
# new_set = my_set.copy()

# # difference(*others) - Returns the difference of two or more sets as a new set
# diff_set = my_set.difference({2, 3})

# # difference_update(*others) - Removes all elements of another set from this set
# my_set.difference_update({2, 3})

# # intersection(*others) - Returns the intersection of two or more sets as a new set
# intersect_set = my_set.intersection({3, 4, 5, 6})

# # intersection_update(*others) - Updates the set with the intersection of itself and another
# my_set.intersection_update({3, 4, 5, 6})

# # isdisjoint(other) - Returns True if two sets have a null intersection
# disjoint = my_set.isdisjoint({7, 8})

# # issubset(other) - Returns True if another set contains this set
# subset = my_set.issubset({1, 2, 3, 4, 5, 6})

# # issuperset(other) - Returns True if this set contains another set
# superset = my_set.issuperset({1, 2})

# # symmetric_difference(other) - Returns the symmetric difference of two sets as a new set
# sym_diff_set = my_set.symmetric_difference({4, 5, 6, 7})

# # symmetric_difference_update(other) - Updates a set with the symmetric difference of itself and another
# my_set.symmetric_difference_update({4, 5, 6, 7})

# # union(*others) - Returns the union of sets as a new set
# union_set = my_set.union({6, 7})

# # update(*others) - Update the set with the union of itself and others
# my_set.update({6, 7})
# -------------------------------------------------------

# 3. Frozensets
# A frozenset is an immutable set. Frozensets are like sets, 
# but they cannot be changed once created. They can be used as keys 
# in dictionaries or elements of other sets.

# Creating Frozensets:
# # Empty frozenset
# my_frozenset = frozenset()

# # Frozenset with elements
# my_frozenset = frozenset([1, 2, 3, 4])
# -------------------------------------------------------
# Frozenset Methods:
# Frozensets have the same methods as sets, except for methods that modify 
# the set, such as add(), remove(), pop(), update(), etc.

# my_frozenset = frozenset([1, 2, 3, 4, 5])

# # copy() - Returns a shallow copy of the frozenset
# new_frozenset = my_frozenset.copy()

# # difference(*others) - Returns the difference of two or more frozensets as a new frozenset
# diff_frozenset = my_frozenset.difference(frozenset([2, 3]))

# # intersection(*others) - Returns the intersection of two or more frozensets as a new frozenset
# intersect_frozenset = my_frozenset.intersection(frozenset([3, 4, 5, 6]))

# # isdisjoint(other) - Returns True if two frozensets have a null intersection
# disjoint = my_frozenset.isdisjoint(frozenset([7, 8]))

# # issubset(other) - Returns True if another frozenset contains this frozenset
# subset = my_frozenset.issubset(frozenset([1, 2, 3, 4, 5, 6]))

# # issuperset(other) - Returns True if this frozenset contains another frozenset
# superset = my_frozenset.issuperset(frozenset([1, 2]))

# # symmetric_difference(other) - Returns the symmetric difference of two frozensets as a new frozenset
# sym_diff_frozenset = my_frozenset.symmetric_difference(frozenset([4, 5, 6, 7]))

# # union(*others) - Returns the union of frozensets as a new frozenset
# union_frozenset = my_frozenset.union(frozenset([6, 7]))


