package org.example.pojo;

/**
 * 汽车实体类，对应数据库中的 t_car 表
 */
public class Car {

    private Long id;            // 对应 id
    private String carNum;      // 对应 car_num
    private String brand;       // 对应 brand
    private Double guidePrice;  // 对应 guide_price
    private String produceTime; // 对应 produce_time
    private String carType;     // 对应 car_type

    // 无参构造
    public Car() {
    }

    // 全参构造
    public Car(Long id, String carNum, String brand, Double guidePrice, String produceTime, String carType) {
        this.id = id;
        this.carNum = carNum;
        this.brand = brand;
        this.guidePrice = guidePrice;
        this.produceTime = produceTime;
        this.carType = carType;
    }

    // Getter 和 Setter (MyBatis 核心依赖)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCarNum() { return carNum; }
    public void setCarNum(String carNum) { this.carNum = carNum; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public Double getGuidePrice() { return guidePrice; }
    public void setGuidePrice(Double guidePrice) { this.guidePrice = guidePrice; }

    public String getProduceTime() { return produceTime; }
    public void setProduceTime(String produceTime) { this.produceTime = produceTime; }

    public String getCarType() { return carType; }
    public void setCarType(String carType) { this.carType = carType; }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", carNum='" + carNum + '\'' +
                ", brand='" + brand + '\'' +
                ", guidePrice=" + guidePrice +
                ", produceTime='" + produceTime + '\'' +
                ", carType='" + carType + '\'' +
                '}';
    }
}