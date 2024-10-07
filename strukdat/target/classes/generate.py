import random

random_array = random.sample(range(1, 10001), 10000)
sorted_array = sorted(random_array)
reverse_array  = list(reversed(sorted_array))

num_swaps = 5


for _ in range(num_swaps):
    i = random.randint(0, len(sorted_array) - 1) 
    j = random.randint(0, len(sorted_array) - 1) 
    sorted_array[i], sorted_array[j] = sorted_array[j], sorted_array[i]

print('random number: ')
print(random_array)
print()