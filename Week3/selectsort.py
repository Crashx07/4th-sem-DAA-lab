import sys


def selection_sort(arr):
    comparisons = 0
    swaps = 0
    n = len(arr)

    for i in range(n - 1):
        min_index = i
        for j in range(i + 1, n):
            comparisons += 1
            if arr[j] < arr[min_index]:
                min_index = j

        if min_index != i:
            arr[i], arr[min_index] = arr[min_index], arr[i]
            swaps += 1

    return comparisons, swaps


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

        comparisons, swaps = selection_sort(arr)

        outputs.append(" ".join(map(str, arr)))
        outputs.append(f"comparisons = {comparisons}")
        outputs.append(f"swaps = {swaps}")

    print("\n".join(outputs))


if __name__ == "__main__":
    main()
