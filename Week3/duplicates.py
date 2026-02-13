
def find_duplicates(arr):
    arr.sort()
    for i in range(len(arr) - 1):
        if arr[i] == arr[i + 1]:
            return True
    return False


def main():
    input_data = sys.stdin.read().strip().split()
    t = int(input_data[0])
    index = 1

    outputs = []
    for _ in range(t):
        n = int(input_data[index])
        index += 1

        arr = list(map(int, input_data[index:index + n]))
        index += n

        if find_duplicates(arr):
            outputs.append("YES")
        else:
            outputs.append("NO")

    print("\n".join(outputs))


main()
