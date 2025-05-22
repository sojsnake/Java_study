package org.scoula.database;

import com.opencsv.bean.CsvToBeanBuilder;
import org.scoula.common.JDBCUtil;
import org.scoula.travel.dao.TravelDao;
import org.scoula.travel.dao.TravelDaoImpl;
import org.scoula.travel.domain.TravelVO;

import java.io.FileReader;
import java.util.List;

// OpenCSV 라이브러리
// CSV 파일을 읽을 때 도와주는 라이브러리
public class ImportTravelData {
    public static void main(String[] args) throws Exception {

        TravelDao dao = new TravelDaoImpl();

        //CsvToBeanBuilder: 읽어온 csv 파일을 travelvo 형태에 맞게 list 형태로 반환해줌
        List<TravelVO> travels = new CsvToBeanBuilder<TravelVO>(new FileReader("travel.csv"))
                .withType(TravelVO.class)
                .build()
                .parse();
        travels.forEach(travel -> {
            System.out.println(travel);
            //객체 형태로 반환
            dao.insert(travel);
        });

//        JDBCUtil.close();
    }
}
