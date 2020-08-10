package Etc;

import java.util.*;

public class 리틀프렌드사천성 {
    private class Block{
        Character c;
        Integer y;
        Integer x;
        Block(Character c, Integer y, Integer x) {
            this.c = c;
            this.y = y;
            this.x = x;
        }
    }

    List<Block> blockList = new LinkedList<>();
    String[] map;
    public String solution(int m, int n, String[] board) {
        String answer = "";

        map = board;
        for(int i = 0; i<m;i++) {
            for(int j= 0 ; j<n;j++){
                if(board[i].charAt(j) != '*' && board[i].charAt(j) != '.')  blockList.add(new Block(board[i].charAt(j),i,j));
            }
        }

        Collections.sort(blockList, new Comparator<Block>() {
                    @Override
                    public int compare(Block o1, Block o2) {
                        return o1.c.compareTo(o2.c);
                    }
                });

        boolean breakBlock = true;
        while(breakBlock || !blockList.isEmpty()) {
            breakBlock = false;
            for(int i = 0;i<blockList.size()-1;i+=2) {
                Block block1 = blockList.get(i);
                Block block2 = blockList.get(i+1);
                if(canBreakBlock(block1,block2)) {
                    breakBlock = true;
                    answer += block1.c;
                    blockList.remove(i);
                    blockList.remove(i);
                }
            }
        }
        if(!blockList.isEmpty()) return "IMPOSSIBLE";
        return answer;
    }
    private boolean canBreakBlock(Block block1, Block block2) {

        int x1 = block1.x;
        int y1 = block1.y;
        char c1 = block1.c;
        int y2 = block2.y;
        int x2 = block2.x;
        int c2 = block2.c;

        boolean canBreak = true;
        if(x1 == x2) {
            if (y1 > y2) {
                for (int i = y2 + 1; i < y1; i++) {
                    if (map[i].charAt(x1) != '.') {
                        canBreak = false;
                        return canBreak;
                    }
                }
            } else {
                for (int i = y1 + 1; i < y2; i++) {
                    if (map[i].charAt(x1) != '.') {
                        canBreak = false;
                        return canBreak;                    }
                }
            }
        }
        else if(y1 ==y2){
            if( x1 > x2) {
                for(int i  = x2+1;i<x1; i++) {
                    if(map[y1].charAt(i) != '.') {
                        canBreak = false;
                        return canBreak;
                    }
                }
            }
            else {
                for(int i  = x1+1;i<x2; i++) {
                    if(map[y1].charAt(i) != '.') {
                        canBreak = false;
                        return canBreak;
                    }
                }

            }
        }
        else {
            boolean row = true, col = true;
            if(x1 > x2 && y1 > y2) {
                for(int i = x2+1;i<x1;i++) {
                    if(map[y2].charAt(i) != '.') {
                        row = false;
                        break;
                    }
                }
                for(int i = y2+1; i < y2;i++) {
                    if(map[i].charAt(x1) != '.') {
                        col = false;
                        break;
                    }
                }
                if(row && col) return true;

                for(int i = y2+1; i<y1;i++) {
                    if(map[i].charAt(x2) != '.') {
                        col = false;
                        break;
                    }
                }
                for(int i = x2+1;i<x1;i++) {
                    if(map[y1].charAt(i) != '.') {
                        row = false;
                        break;
                    }
                }
                if(row && col) return true;
                return false;
            }
            else if(x1 < x2 && y1 > y2) {

            }
            else if( x1 > x2 && y1 < y2) {

            }
            else { //x1 < x2 && y1 < y2

            }
        }
        return true; //일단해논거
    }
}
