class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        Map<Integer, Integer> m = new HashMap<>();
        int target=-1;
        for (int i=0;i<tops.length;i++) {
            if (!m.containsKey(tops[i])) {
                m.put(tops[i], 1);
            } else {
                m.put(tops[i], m.get(tops[i])+1);
            }
            if (!m.containsKey(bottoms[i])) {
                m.put(bottoms[i], 1);
            } else {
                m.put(bottoms[i], m.get(bottoms[i])+1);
            }
            if (m.get(tops[i]) >= tops.length) {
                target = tops[i];
            } else if (m.get(bottoms[i]) >= bottoms.length) {
                target = bottoms[i];
            }
        }
        System.out.println(m);
        System.out.println(target);
        if (target == -1) {
            return -1;
        }
        int min=findRotations(tops, bottoms, target);
        return min;
    }
    private int findRotations(int[] tops, int[] bottoms, int target) {
        int toprotate=0;
        int bottomrotate=0;
        for (int i=0;i<tops.length;i++) {
            if(tops[i] != target && bottoms[i] != target) {
                return -1;
            }
            if (tops[i] != target) {
                toprotate++;
            }
            if (bottoms[i] != target) {
                bottomrotate++;
            }
        }
        return Math.min(bottomrotate, toprotate);
    }
}
