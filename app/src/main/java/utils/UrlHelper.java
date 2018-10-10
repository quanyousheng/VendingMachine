package utils;

/**
 * Created by Administrator on 2016/9/29.
 */
public class UrlHelper {
    public static final String project = "local";
//    public static final String project = "benxiao";
//      public static final String project = "newaite";

    public static final String URL_IP = "http://yyg.zhi-ren.cn";
//    public static final String URL_IP = "http://benxiao.cnmar.com";
//    public static final String URL_IP = "http://ims.newaite.com";//新爱特

    //   后台接口地址
    public static final String URL_BASE = URL_IP + "/webservice.asmx/";

    //  显示图片的绝对路径
    public static final String URL_IMAGE = URL_IP + ":8090";

    //   后台地址
    public static final String URL_ADMIN = URL_IP + ":8091";//内网需要端口号
//    public static final String URL_ADMIN = URL_IP;

    //    原料出入库扫描
    public static final String URL_MATERIAL_SCAN = URL_BASE + "/material_in_order/qrcode";

    //    成品出入库扫描
    public static final String URL_PRODUCT_SCAN = URL_BASE + "/product_in_order/qrcode";

    //    半成品出入库扫描
    public static final String URL_HALF_PRODUCT_SCAN = URL_BASE + "/half_in_order/qrcode";

    //     原料质量追溯扫描
    public static final String URL_MATERIAL_TRACE_BACK_SCAN = URL_BASE + "/material_in_order/back";

    //     成品质量追溯扫描
    public static final String URL_PRODUCT_TRACE_BACK_SCAN = URL_BASE + "/product_in_order/back";


    public static final String URL_LOGIN = URL_BASE + "/login_commit?username={username}&password={password}";
    public static final String URL_PROFILE = URL_BASE + "/system_user/personal/{ID}";
    public static final String URL_CHECK_STOCK = URL_BASE + "/material_stock_check/detail/{ID}";
    public static final String URL_STOCK_CHECK_MANAGE = URL_BASE + "/material_stock_check_manage/detail/{ID}";
    public static final String URL_CHECK_COMMIT = URL_BASE + "/material_stock_check_manage/check_commit?stockId={stockId}&spaceStockIds={spaceStockIds}&spaceIds={spaceIds}&inOrderSpaceIds={inOrderSpaceIds}&beforeStocks={beforeStocks}&afterStocks={afterStocks}";
    public static final String URL_IN_ORDER_DETAIL = URL_BASE + "/material_in_order/detail/{id}";
    public static final String URL_OUT_ORDER_DETAIL = URL_BASE + "/material_out_order/detail/{id}";
    public static final String URL_OUT_COMMIT = URL_BASE + "/material_out_order/out_stock_commit?outOrderId={outOrderId}&outOrderSpaceIds={outOrderSpaceIds}&preOutStocks={preOutStocks}&outStocks={outStocks}";
    public static final String URL_STOCK_DETAIL = URL_BASE + "/material_stock/detail/{id}";
    public static final String URL_PRODUCT_CHECK_STOCK = URL_BASE + "/product_stock_check/detail/{ID}";
    public static final String URL_PRODUCT_CHECK_STOCK_MANAGE = URL_BASE + "/product_stock_check_manage/detail/{ID}";

    public static final String URL_PRODUCT_CHECK_STOCK_COMMIT = URL_BASE + "/product_stock_check_manage/check_commit?stockId={stockId}&spaceStockIds={spaceStockIds}&spaceIds={spaceIds}&inOrderSpaceIds={inOrderSpaceIds}&beforeStocks={beforeStocks}&afterStocks={afterStocks}";

    public static final String URL_PRODUCT_STOCK_DETAIL = URL_BASE + "/product_stock/detail/{id}";
    public static final String URL_TEST_COMMIT = URL_BASE + "/material_in_order/test_commit?inOrderId={inOrderId}&testId={testId}&testRemark={testRemark}&inOrderMaterialIds={inOrderMaterialIds}&res={res}&failNums={failNums}";
    public static final String URL_IN_ORDER_COMMIT = URL_BASE + "/material_in_order/in_stock_commit?inOrderId={inOrderId}&inOrderSpaceIds={inOrderSpaceIds}&preInStocks={preInStocks}&inStocks={inStocks}";
    public static final String URL_IN_ORDER = URL_BASE + "/material_in_order/list?query.code=&page.num={page}";
    public static final String URL_SEARCH_IN_ORDER = URL_BASE + "/material_in_order/list?query.code={query.code}&query.status={query.status}&page.num=1";
    public static final String URL_CHECK_MANAGE = URL_BASE + "/material_stock_check_manage/list?query.code=&page.num={page}";
    public static final String URL_SEARCH_CHECK_MANAGE = URL_BASE + "/material_stock_check_manage/list?query.code={query.code}&page.num=1";
    public static final String URL_CHECK_QUERY = URL_BASE + "/material_stock_check/list?query.code=&page.num={page}";
    public static final String URL_SEARCH_CHECK_QUERY = URL_BASE + "/material_stock_check/list?query.code={query.code}&page.num=1";

    public static final String URL_STOCK = URL_BASE + "/material_stock/list?query.code=&page.num={page}";
    public static final String URL_SEARCH_STOCK = URL_BASE + "/material_stock/list?query.code={query.code}&page.num=1";

    public static final String URL_OUT_ORDER = URL_BASE + "/material_out_order/list?query.code=&page.num={page}";
    public static final String URL_SEARCH_OUT_ORDER = URL_BASE + "/material_out_order/list?query.code={query.code}&query.status={query.status}&page.num=1";

    public static final String URL_PRODUCT_CHECK_MANAGE = URL_BASE + "/product_stock_check_manage/list?query.code=&page.num={page}";
    public static final String URL_PRODUCT_SEARCH_CHECK_MANAGE = URL_BASE + "/product_stock_check_manage/list?query.code={query.code}&page.num=1";

    public static final String URL_PRODUCT_CHECK_QUERY = URL_BASE + "/product_stock_check/list?query.code=&page.num={page}";
    public static final String URL_PRODUCT_SEARCH_CHECK_QUERY = URL_BASE + "/product_stock_check/list?query.code={query.code}&page.num=1";

    public static final String URL_PRODUCT_STOCK = URL_BASE + "/product_stock/list?query.code=&page.num={page}";
    public static final String URL_PRODUCT_SEARCH_STOCK = URL_BASE + "/product_stock/list?query.code={query.code}&page.num=1";

    public static final String URL_PRODUCE_PLAN = URL_BASE + "/produce_plan/list?query.code=&page.num={page}";//加工单列表
    public static final String URL_SEARCH_PRODUCE_PLAN = URL_BASE + "/produce_plan/list?query.code={query.code}&page.num=1";
    public static final String URL_PRODUCE_BOM = URL_BASE + "/produce_bom/list?query.code=&page.num={page}";//子加工单列表
    public static final String URL_SEARCH_PRODUCE_BOM = URL_BASE + "/produce_bom/list?query.code={query.code}&page.num=1";
    public static final String URL_DELIVERY_PLAN = URL_BASE + "/custom_deliver_plan/list?query.code=&page.num={page}";
    public static final String URL_SEARCH_DELIVERY_PLAN = URL_BASE + "/custom_deliver_plan/list?query.code={query.code}&page.num=1";

    public static final String URL_RECEIVE_MATERIAL_ORDER = URL_BASE + "/produce_receive/list?query.code=&page.num={page}";
    public static final String URL_SEARCH_RECEIVE_MATERIAL_ORDER = URL_BASE + "/produce_receive/list?query.code={query.code}&query.status={query.status}&page.num=1";
    public static final String URL_RECEIVE_MATERIAL_ORDER_DETAIL = URL_BASE + "/produce_receive/detail/{ID}";

    public static final String URL_PRODUCE_PLAN_DETAIL = URL_BASE + "/produce_plan/detail/{ID}";//加工单详情
    public static final String URL_PRODUCE_BOM_DETAIL = URL_BASE + "/produce_bom/detail/{ID}";//子加工单详情
    public static final String URL_DELIVERY_PLAN_DETAIL = URL_BASE + "/custom_deliver_plan/detail/{ID}";

    public static final String URL_RECEIVE_MATERIAL_COMMIT = URL_BASE + "/produce_plan/receive_commit?producePlanId={ID}&receiveId={receiveId}";//加工单领料
    public static final String URL_PRODUCT_PRE_IN_STOCK_COMMIT = URL_BASE + "/produce_plan/pre_in_stock_commit?batchId={batchId}&successNum={successNum}&testId={testId}&testRemark={testRemark}";//成品提交待入库
    public static final String URL_PRODUCT_ACTUAL_NUM_COMMIT = URL_BASE + "/produce_plan/actual_num_commit?producePlanId={ID}&actualNum={actualNum}&actualId={actualId}&lastProcessBoxIds={lastProcessBoxIds}&status={status}";//成品提交待检验

    public static final String URL_BOM_RECEIVE_MATERIAL_COMMIT = URL_BASE + "/produce_bom/receive_commit?produceBomId={ID}&receiveId={receiveId}";//子加工单领料
    public static final String URL_HALF_PRODUCT_PRE_IN_STOCK_COMMIT = URL_BASE + "/produce_bom/pre_in_stock_commit?batchId={batchId}&successNum={successNum}&testId={testId}&testRemark={testRemark}";//半成品提交待入库
    public static final String URL_HALF_PRODUCT_ACTUAL_NUM_COMMIT = URL_BASE + "/produce_bom/actual_num_commit?produceBomId={ID}&actualNum={actualNum}&actualId={actualId}&lastProcessBoxIds={lastProcessBoxIds}&status={status}";//半成品提交待检验


    public static final String URL_PRODUCT_IN_ORDER = URL_BASE + "/product_in_order/list?query.code=&page.num={page}";
    public static final String URL_SEARCH_PRODUCT_IN_ORDER = URL_BASE + "/product_in_order/list?query.code={query.code}&query.status={query.status}&page.num=1";
    public static final String URL_PRODUCT_OUT_ORDER = URL_BASE + "/product_out_order/list?query.code=&page.num={page}";
    public static final String URL_SEARCH_PRODUCT_OUT_ORDER = URL_BASE + "/product_out_order/list?query.code={query.code}&query.status={query.status}&page.num=1";
    public static final String URL_PRODUCT_IN_ORDER_DETAIL = URL_BASE + "/product_in_order/detail/{id}";
    public static final String URL_PRODUCT_OUT_ORDER_DETAIL = URL_BASE + "/product_out_order/detail/{id}";
    public static final String URL_PRODUCT_IN_ORDER_COMMIT = URL_BASE + "/product_in_order/in_stock_commit?inOrderId={inOrderId}&inOrderSpaceIds={inOrderSpaceIds}&preInStocks={preInStocks}&inStocks={inStocks}";
    public static final String URL_PRODUCT_OUT_COMMIT = URL_BASE + "/product_out_order/out_stock_commit?outOrderId={outOrderId}&outOrderSpaceIds={outOrderSpaceIds}&preOutStocks={preOutStocks}&outStocks={outStocks}";

    public static final String URL_QC_LIST = URL_BASE + "/material_in_order_test/list?query.code=&page.num={page}";
    public static final String URL_SEARCH_QC_LIST = URL_BASE + "/material_in_order_test/list?query.code={query.code}&page.num=1";

    public static final String URL_QC_DETAIL = URL_BASE + "/material_in_order_test/detail/{id}";

    public static final String URL_HALF_QC_LIST = URL_BASE + "/produce_half_test/list?query.code=&page.num={page}";
    public static final String URL_SEARCH_HALF_QC_LIST = URL_BASE + "/produce_half_test/list?query.code={query.code}&page.num=1";
    public static final String URL_HALF_QC_DETAIL = URL_BASE + "/produce_half_test/detail/{ID}";


    public static final String URL_PRODUCT_QC_LIST = URL_BASE + "/produce_product_test/list?query.code=&page.num={page}";
    public static final String URL_SEARCH_PRODUCT_QC_LIST = URL_BASE + "/produce_product_test/list?query.code={query.code}&page.num=1";
    public static final String URL_PRODUCT_QC_DETAIL = URL_BASE + "/produce_product_test/detail/{ID}";

    public static final String URL_COMPANY_LIST = URL_BASE + "/company/list?query.name=&page.num={page}";
    public static final String URL_SEARCH_COMPANY_LIST = URL_BASE + "/company/list?query.name={query.code}&page.num=1";

    public static final String URL_COMPANY_DETAIL = URL_BASE + "/company/detail/{id}";

    public static final String URL_PRODUCT_LIST = URL_BASE + "/company_product/list?query.name=&page.num={page}";
    public static final String URL_SEARCH_PRODUCT_LIST = URL_BASE + "/company_product/list?query.name={query.code}&page.num=1";

    public static final String URL_PRODUCT_DETAIL = URL_BASE + "/company_product/detail/{id}";

    public static final String URL_SUPPLY_LIST = URL_BASE + "/supply/list?query.name=&page.num={page}";
    public static final String URL_SEARCH_SUPPLY_LIST = URL_BASE + "/supply/list?query.name={query.code}&page.num=1";

    public static final String URL_SUPPLY_DETAIL = URL_BASE + "/supply/detail/{id}";

    //    半成品仓库
    public static final String URL_HALF_PRODUCT_STOCK = URL_BASE + "/half_stock/list?query.code=&page.num={page}";
    public static final String URL_SEARCH_HALF_PRODUCT_STOCK = URL_BASE + "/half_stock/list?query.code={query.code}&page.num=1";
    public static final String URL_HALF_PRODUCT_STOCK_DETAIL = URL_BASE + "/half_stock/detail/{id}";
    public static final String URL_HALF_PRODUCT_IN_ORDER = URL_BASE + "/half_in_order/list?query.code=&page.num={page}";
    public static final String URL_SEARCH_HALF_PRODUCT_IN_ORDER = URL_BASE + "/half_in_order/list?query.code={query.code}&query.status={query.status}&page.num=1";
    public static final String URL_HALF_PRODUCT_OUT_ORDER = URL_BASE + "/half_out_order/list?query.code=&page.num={page}";
    public static final String URL_SEARCH_HALF_PRODUCT_OUT_ORDER = URL_BASE + "/half_out_order/list?query.code={query.code}&query.status={query.status}&page.num=1";
    public static final String URL_HALF_PRODUCT_IN_ORDER_DETAIL = URL_BASE + "/half_in_order/detail/{id}";
    public static final String URL_HALF_PRODUCT_OUT_ORDER_DETAIL = URL_BASE + "/half_out_order/detail/{id}";
    public static final String URL_HALF_PRODUCT_IN_ORDER_COMMIT = URL_BASE + "/half_in_order/in_stock_commit?inOrderId={inOrderId}&inOrderSpaceIds={inOrderSpaceIds}&preInStocks={preInStocks}&inStocks={inStocks}";
    public static final String URL_HALF_PRODUCT_OUT_COMMIT = URL_BASE + "/half_out_order/out_stock_commit?outOrderId={outOrderId}&outOrderSpaceIds={outOrderSpaceIds}&preOutStocks={preOutStocks}&outStocks={outStocks}";

    public static final String URL_HALF_PRODUCT_CHECK_MANAGE = URL_BASE + "/half_stock_check_manage/list?query.code=&page.num={page}";
    public static final String URL_SEARCH_HALF_PRODUCT_CHECK_MANAGE = URL_BASE + "/half_stock_check_manage/list?query.code={query.code}&page.num=1";
    public static final String URL_HALF_PRODUCT_CHECK_MANAGE_DETAIL = URL_BASE + "/half_stock_check_manage/detail/{ID}";
    public static final String URL_HALF_PRODUCT_CHECK_COMMIT = URL_BASE + "/half_stock_check_manage/check_commit?stockId={stockId}&spaceStockIds={spaceStockIds}&spaceIds={spaceIds}&inOrderSpaceIds={inOrderSpaceIds}&beforeStocks={beforeStocks}&afterStocks={afterStocks}";

    public static final String URL_HALF_PRODUCT_CHECK_QUERY = URL_BASE + "/half_stock_check/list?query.code=&page.num={page}";
    public static final String URL_SEARCH_HALF_PRODUCT_CHECK_QUERY = URL_BASE + "/half_stock_check/list?query.code={query.code}&page.num=1";
    public static final String URL_HALF_PRODUCT_CHECK_QUERY_DETAIL = URL_BASE + "/half_stock_check/detail/{ID}";

    //    系统设置
    public static final String URL_SYSTEM_LOG = URL_BASE + "/system_log/list?query.name=&page.num={page}";
    public static final String URL_SEARCH_SYSTEM_LOG = URL_BASE + "/system_log/list?query.name={query.code}&page.num=1";
    public static final String URL_SYSTEM_USER = URL_BASE + "/system_user/list?query.name=&page.num={page}";
    public static final String URL_SEARCH_SYSTEM_USER = URL_BASE + "/system_user/list?query.name={query.code}&page.num=1";
    public static final String URL_SYSTEM_USER_DETAIL = URL_BASE + "/system_user/detail/{ID}";

    // 报表地址
    public static final String URL_MATERIAL_REPORT = URL_ADMIN + "/material_report/show";
    public static final String URL_HALF_REPORT = URL_ADMIN + "/half_report/show";
    public static final String URL_PRODUCT_REPORT = URL_ADMIN + "/product_report/show";

    //    生产管理
    public static final String URL_SCANN_STATION = URL_BASE + "/com_station/qrcode/";//机床扫描
    public static final String URL_SCANN_STATION_DETAIL = URL_BASE + "/com_station/detail/{ID}?planId={planId}&bomId={bomId}&processId={processId}&userId={userId}";//加工任务详情
    public static final String URL_SCANN_BOX = URL_BASE + "/com_box/qrcode/";//料框扫描
    public static final String URL_IN_BOX = URL_BASE + "/com_box/in_commit?boxId={boxId}&planId={planId}&bomId={bomId}&processId={processId}&stationId={stationId}&num={num}&userId={userId}";//入料框
    public static final String URL_FAIL_IN_BOX_COMMIT = URL_BASE + "/com_box/fail_in_commit?boxId={boxId}&testBoxId={testBoxId}&planId={planId}&bomId={bomId}&processId={processId}&stationId={stationId}&failNum={failNum}&testRemark={testRemark}&testId={testId}";//不合格品入料框
    public static final String URL_BIN = URL_BASE + "/com_box/list?query.userId={userId}&query.type={type}&query.code=&page.num={page}";//线边仓
    public static final String URL_SEARCH_BIN = URL_BASE + "/com_box/list?query.userId={userId}&query.type={type}&query.code={code}&page.num=1";//查找线边仓
    public static final String URL_CHECK_FLOW = URL_BASE + "/produce_test/list?query.userId={userId}&query.type={type}&query.code=&page.num={page}";//检验流水
    public static final String URL_SEARCH_CHECK_FLOW = URL_BASE + "/produce_test/list?query.userId={userId}&query.type={type}&query.code={code}&page.num=1";//查找检验流水
    public static final String URL_CHECK_FLOW_DETAIL = URL_BASE + "/produce_test/detail/{Id}";//检验流水详情
    public static final String URL_PREV_OUT_COMMIT = URL_BASE + "/com_box/prev_out_commit?boxId={boxId}&num={num}";//上工序合格品出料框
}
