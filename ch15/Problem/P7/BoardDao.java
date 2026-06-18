package ch15.Problem.P7;

import ch08.sec10.exam01.E;

import java.util.ArrayList;
import java.util.List;

public class BoardDao {


   /* public List<Board> getBoardList(){
        List<Board> list = new ArrayList<>();
        for(int i=1;i<4;i++){
            list.add(new Board("제목"+i,"내용"+i));
        }
        return list;
    }*/

    private List<Board> list = new ArrayList<>();
    public BoardDao(){
        list.add(new Board("제목1","내용1"));
        list.add(new Board("제목2","내용2"));
        list.add(new Board("제목3","내용3"));

    }

    public List<Board> getBoardList(){
        return list;
    }
}
