package Programmers;

import java.util.Arrays;

public class TrainTracks {
    int n,m;
    int used[][];
    int map[][];
    int targetcount = 0;
    int answer = 0;
    public int solution(int[][] grid) {

        n = grid.length;
        m = grid[0].length;

        map = new int[n+2][m+2];
        used = new int[n+2][m+2];

        for(int i=0; i<n+2;i++){
            Arrays.fill(map[i],-1);
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int tile = grid[i][j];
                map[i+1][j+1] = tile;

                if (tile == 3) targetcount +=2;
                else if(tile > 0) targetcount++;
            }
        }

        dfs(1,1,1,1);
        return answer;
    }

    private void dfs(int dir, int x, int y , int count){
        //dir 왼,위,오,아 = 1,2,3,4
        int tile = map[x][y];

        //장애물에 막혀 있을 때
        if(tile == -1) return;

        //도착
        if(x == n && y == m ){
            if (count == targetcount){
                if (dir == 1 && tile == 1) answer++;
                else if (dir == 2 && tile==2)answer++;
            }
            return;
        }

        //왼쪽에서 진입
        if(dir == 1){
            if (tile == 1 || tile == 3){
                dfs(1,x,y+1,count+1);
            }else if(tile == 4){
                dfs(4,x-1,y,count+1);
            }else if(tile == 7){
                dfs(2,x+1,y,count+1);
            }else if(tile == 0){
                if(used[x][y] == 3){
                    dfs(1,x,y+1,count);
                }else if(used[x][y]==0){
                    used[x][y] = 3;
                    dfs(1,x,y+1,count);

                    used[x][y] = 4;
                    dfs(4,x-1,y,count);

                    used[x][y] = 7;
                    dfs(2,x+1,y,count);

                    used[x][y] = 0;
                }
            }
        }
        //위쪽 진입
        else if(dir == 2){
            if (tile == 2 || tile == 3){
                dfs(2,x+1,y,count+1);
            }else if(tile == 4){
                dfs(3,x,y-1,count+1);
            }else if(tile == 5){
                dfs(1,x,y+1,count+1);
            }else if(tile == 0){
                if(used[x][y] == 3){
                    dfs(2,x+1,y,count);
                }else if(used[x][y]==0){
                    used[x][y] = 3;
                    dfs(2,x+1,y,count);

                    used[x][y] = 4;
                    dfs(3,x,y-1,count);

                    used[x][y] = 5;
                    dfs(1,x,y+1,count);

                    used[x][y] = 0;
                }
            }
        }
        //오른쪽 진입
        else if(dir == 3){
            if (tile == 1 || tile == 3){
                dfs(3,x,y-1,count+1);
            }else if(tile == 5){
                dfs(4,x-1,y,count+1);
            }else if(tile == 6){
                dfs(2,x+1,y,count+1);
            }else if(tile == 0){
                if(used[x][y] == 3){
                    dfs(3,x,y-1,count);
                }else if(used[x][y]==0){
                    used[x][y] = 3;
                    dfs(3,x,y-1,count);

                    used[x][y] = 5;
                    dfs(4,x-1,y,count);

                    used[x][y] = 6;
                    dfs(2,x+1,y,count);

                    used[x][y] = 0;
                }
            }
        }

        //아래쪽 진입
        else if(dir == 4){
            if (tile == 2 || tile == 3){
                dfs(4,x-1,y,count+1);
            }else if(tile == 6){
                dfs(1,x,y+1,count+1);
            }else if(tile == 7){
                dfs(3,x,y-1,count+1);
            }else if(tile == 0){
                if(used[x][y] == 3){
                    dfs(4,x-1,y,count);
                }else if(used[x][y]==0){
                    used[x][y] = 3;
                    dfs(4,x-1,y,count);

                    used[x][y] = 6;
                    dfs(1,x,y+1,count);

                    used[x][y] = 7;
                    dfs(3,x,y-1,count);

                    used[x][y] = 0;
                }
            }
        }
    }
}