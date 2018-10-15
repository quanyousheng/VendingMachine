package retrofit;

import model.Ad;
import model.MachineLogin;
import model.PayOrder;
import model.Product;
import model.ProductByNO;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface ApiService {

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


    /*
     *设备登录校验
     * */
    @GET("MachineLogin")
    Observable<MachineLogin> login(
            @Query("no") String no,
            @Query("mackey") String mackey
    );

    /*
   *获得广告图
   * */
    @GET("GetAdvList")
    Observable<Ad> getAdvList(
    );

    /*
  *支付
  * */
    @GET("PayOrder")
    Observable<PayOrder> pay(
            @Query("id") int id
    );
}
