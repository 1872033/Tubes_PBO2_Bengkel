package Utility;

import java.util.List;


public interface DaoService<T> {
    List<T> fetchAll() ;

    int addData(T object) ;

    int editData(T object) ;

    int deleteData(T object) ;

}
