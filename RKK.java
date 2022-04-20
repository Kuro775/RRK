public class RKK {
    public static void main() {
        for (int i = 0; i< 16; i++) {
            for (int j = 0; j < 16; j++) {
                for (int k = 0; k < 16; k++) {
                    if (i != j && j != k && i != k) {
                        whoWin(i,j,k,true);
                        whoWin(i,j,k,false);
                    }
                }
            }
        }
    }
    
    private static String loc(int p) {
        return "" + (char)((p/4) + 97) + (p%4+1);
    }
    
    private static void print(int k1, int k2, int r, boolean isWhite, String res) {
        System.out.println("[" + loc(k1) + ", " + loc(k2) + ", " + loc(r) + ", " + (isWhite? "W": "B") + "]: " + res);
    }
    
    private static void whoWin(int k1, int k2, int r, boolean isWhite) {
        if (isAdjacent(k1,k2)) {
            print(k1, k2, r, isWhite, "IL");
        } else if (isWhite || ((!isAdjacent(k2,r) || isAdjacent(k1,r)) && canMove(k1, k2, r))) {
            print(k1, k2, r, isWhite, "W");
        } else {
            print(k1, k2, r, isWhite, "B");
        }
    }
    
    private static boolean isAdjacent(int p1, int p2) {
        return Math.abs((p1/4)-(p2/4)) < 2 && Math.abs((p1%4)-(p2%4)) < 2 && p1 != p2;
    }
    
    private static boolean canMove(int k1, int k2, int r) {
        for (int i = 0; i < 16; i++) {
            //System.out.println(i + " " + r + " " + isRooked(i,r));
            if (isAdjacent (i,k2) && !isAdjacent (i, k1) && !isRooked(i,r, k1)) {                
                return true;
            }
        }
        return false;
    }
    
    private static boolean isRooked(int p, int r, int k1) {
        return ((p/4 == r/4) && !((k1/4 == r/4) && ((k1 < r && p < k1) || (k1 > r && p > k1)))
           || (p%4 == r%4) && !((k1%4 == r%4) && ((k1 < r && p < k1) || (k1 > r && p > k1))));
    }
}