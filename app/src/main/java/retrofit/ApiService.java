package retrofit;

import java.util.List;

import model.Machine;
import model.Product;
import model.ProductById;
import model.ProductByNO;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface ApiService {
    /*
   * 获得所有设备
   * */
    @GET("GetAllMachine")
    Observable<List<Machine>> getAllMachine(
    );

    /*
    *根据设备id获得商品列表
    * */
    @GET("GetMachineProductByID")
    Observable<ProductById> getMachineProductByID(
            @Query("id") int id,
            @Query("pageSize") int pageSize,
            @Query("page") int page
    );

    /*
    *根据设备编码获得商品列表
    * */
    @GET("GetMachineProductByNO")
    Observable<ProductByNO> getMachineProductByNO(
            @Query("no") String no,
            @Query("pageSize") int pageSize,
            @Query("page") int page
    );

    /*
    *获得商品详情
    * */
    @GET("GetProductInfo")
    Observable<Product> getProductInfo(
            @Query("id") int id
    );

}
