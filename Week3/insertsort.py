import sys


def insertion_sort(arr):
    comparisons = 0
    shifts = 0
    n = len(arr)

    for i in range(1, n):
        key = arr[i]
        j = i - 1

        while j >= 0:
            comparisons += 1
            if arr[j] > key:
                arr[j + 1] = arr[j]
                shifts += 1
                j -= 1
            else:
                break

        arr[j + 1] = key

    return comparisons, shifts


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

        comparisons, shifts = insertion_sort(arr)

        outputs.append(" ".join(map(str, arr)))
        outputs.append(f"comparisons = {comparisons}")
        outputs.append(f"shifts = {shifts}")

    print("\n".join(outputs))


if __name__ == "__main__":
    main()
