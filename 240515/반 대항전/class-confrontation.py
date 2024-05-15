n = int(input())

records = []
for _ in range(4):
    string = input()
    class_name = string[0]
    score = sum(map(int, string[3:].split()))
    print(class_name + " - " + str(score))
    records.append([score, class_name])
records.sort(reverse=True)
print("Class " + records[0][1] + " is winner!")