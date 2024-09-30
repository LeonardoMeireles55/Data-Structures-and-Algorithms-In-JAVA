package MyLeetCode;

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        System.out.println("XOR: " + xor);
        
        while(xor != 0) {
            count += xor & 1;
            
            xor >>= 1;
        }
        return count;
    }
    public static void main(String[] args) {
        int x = 1;
        int y = 4;
        HammingDistance hammingDistance = new HammingDistance();
        System.out.println("Haming distance: " + hammingDistance.hammingDistance(x, y));
    }
}
// Complexity time/space O(1)

// x = 1, y = 4
// x = 0001, y = 0100
// table
// XOR
//------------------------------
// x      |     y    |     ⊕ 
// 0            0           0
// 0            1           1
// 0            0           0
// 1            0           1
//-----------------------------
// 0000(101) = 5
// count = 2 

// x = 5, y = 7
// x = 0000101
// y = 0000111
// table
// XOR
//------------------------------
// x      |     y    |     ⊕
// 0            0           0
// 0            0           0
// 0            0           0
// 0            0           0
// 1            1           0
// 0            1           1
// 1            1           0
//-----------------------------
// 00000(1)0
// count = 2