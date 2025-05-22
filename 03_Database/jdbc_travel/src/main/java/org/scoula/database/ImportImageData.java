package org.scoula.database;

import org.scoula.travel.dao.TravelDao;
import org.scoula.travel.dao.TravelDaoImpl;
import org.scoula.travel.domain.TravelImageVO;

import java.io.File;

public class ImportImageData {
    public static void main(String[] args) {
        //데이터베이스에 저장 -> dao
        TravelDao dao = new TravelDaoImpl();

        File dir = new File("../travel-image");

        //디렉토리에 있는 모든 파일들을 File 배열로 return
        File[] files = dir.listFiles();

        for(File file : files){
            String fileName = file.getName();
            //001 형태를 long으로 받아옴 -> 1
            long travelNo = Long.parseLong(fileName.split("-")[0]);

            TravelImageVO imageVO = TravelImageVO.builder()
                    .filename(fileName)
                    .travelNo(travelNo)
                    .build();
            System.out.println(imageVO);
            dao.insertImage(imageVO);
        }
    }
}
