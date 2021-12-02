package com.triton.healthZpartners.responsepojo;

import java.util.List;

public class FetchProductByUserIDResponse {

    /**
     * Status : Success
     * Message : Product details list
     * Data : [{"cat_id":{"_id":"60e6ffbafe7500511a7b419d","img_path":"http://54.212.108.156:3000/api/uploads/1625751478722.png","product_cate":"Pet Accessories","img_index":0,"show_status":true,"date_and_time":"7/8/2021, 7:08:01 PM","delete_status":false,"updatedAt":"2021-07-08T13:38:02.721Z","createdAt":"2021-07-08T13:38:02.721Z","__v":0},"product_id":"61a88aad02651d5e799071a5","products_image":[{"product_img":"http://35.164.43.170:3000/api/uploads/1638435359547.jpg"}],"thumbnail_image":"http://35.164.43.170:3000/api/uploads/1638435359547.jpg","product_name":"","product_desc":"Pet Accessories","product_price":200,"pet_threshold":"66","today_deal":false}]
     * Code : 200
     */

    private String Status;
    private String Message;
    private int Code;
    /**
     * cat_id : {"_id":"60e6ffbafe7500511a7b419d","img_path":"http://54.212.108.156:3000/api/uploads/1625751478722.png","product_cate":"Pet Accessories","img_index":0,"show_status":true,"date_and_time":"7/8/2021, 7:08:01 PM","delete_status":false,"updatedAt":"2021-07-08T13:38:02.721Z","createdAt":"2021-07-08T13:38:02.721Z","__v":0}
     * product_id : 61a88aad02651d5e799071a5
     * products_image : [{"product_img":"http://35.164.43.170:3000/api/uploads/1638435359547.jpg"}]
     * thumbnail_image : http://35.164.43.170:3000/api/uploads/1638435359547.jpg
     * product_name :
     * product_desc : Pet Accessories
     * product_price : 200
     * pet_threshold : 66
     * today_deal : false
     */

    private List<DataBean> Data;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int Code) {
        this.Code = Code;
    }

    public List<DataBean> getData() {
        return Data;
    }

    public void setData(List<DataBean> Data) {
        this.Data = Data;
    }

    public static class DataBean {
        /**
         * _id : 60e6ffbafe7500511a7b419d
         * img_path : http://54.212.108.156:3000/api/uploads/1625751478722.png
         * product_cate : Pet Accessories
         * img_index : 0
         * show_status : true
         * date_and_time : 7/8/2021, 7:08:01 PM
         * delete_status : false
         * updatedAt : 2021-07-08T13:38:02.721Z
         * createdAt : 2021-07-08T13:38:02.721Z
         * __v : 0
         */

        private CatIdBean cat_id;
        private String product_id;
        private String thumbnail_image;
        private String product_name;
        private String product_desc;
        private int product_price;
        private String pet_threshold;
        private boolean today_deal;
        /**
         * product_img : http://35.164.43.170:3000/api/uploads/1638435359547.jpg
         */

        private List<ProductsImageBean> products_image;

        public CatIdBean getCat_id() {
            return cat_id;
        }

        public void setCat_id(CatIdBean cat_id) {
            this.cat_id = cat_id;
        }

        public String getProduct_id() {
            return product_id;
        }

        public void setProduct_id(String product_id) {
            this.product_id = product_id;
        }

        public String getThumbnail_image() {
            return thumbnail_image;
        }

        public void setThumbnail_image(String thumbnail_image) {
            this.thumbnail_image = thumbnail_image;
        }

        public String getProduct_name() {
            return product_name;
        }

        public void setProduct_name(String product_name) {
            this.product_name = product_name;
        }

        public String getProduct_desc() {
            return product_desc;
        }

        public void setProduct_desc(String product_desc) {
            this.product_desc = product_desc;
        }

        public int getProduct_price() {
            return product_price;
        }

        public void setProduct_price(int product_price) {
            this.product_price = product_price;
        }

        public String getPet_threshold() {
            return pet_threshold;
        }

        public void setPet_threshold(String pet_threshold) {
            this.pet_threshold = pet_threshold;
        }

        public boolean isToday_deal() {
            return today_deal;
        }

        public void setToday_deal(boolean today_deal) {
            this.today_deal = today_deal;
        }

        public List<ProductsImageBean> getProducts_image() {
            return products_image;
        }

        public void setProducts_image(List<ProductsImageBean> products_image) {
            this.products_image = products_image;
        }

        public static class CatIdBean {
            private String _id;
            private String img_path;
            private String product_cate;
            private int img_index;
            private boolean show_status;
            private String date_and_time;
            private boolean delete_status;
            private String updatedAt;
            private String createdAt;
            private int __v;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getImg_path() {
                return img_path;
            }

            public void setImg_path(String img_path) {
                this.img_path = img_path;
            }

            public String getProduct_cate() {
                return product_cate;
            }

            public void setProduct_cate(String product_cate) {
                this.product_cate = product_cate;
            }

            public int getImg_index() {
                return img_index;
            }

            public void setImg_index(int img_index) {
                this.img_index = img_index;
            }

            public boolean isShow_status() {
                return show_status;
            }

            public void setShow_status(boolean show_status) {
                this.show_status = show_status;
            }

            public String getDate_and_time() {
                return date_and_time;
            }

            public void setDate_and_time(String date_and_time) {
                this.date_and_time = date_and_time;
            }

            public boolean isDelete_status() {
                return delete_status;
            }

            public void setDelete_status(boolean delete_status) {
                this.delete_status = delete_status;
            }

            public String getUpdatedAt() {
                return updatedAt;
            }

            public void setUpdatedAt(String updatedAt) {
                this.updatedAt = updatedAt;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public int get__v() {
                return __v;
            }

            public void set__v(int __v) {
                this.__v = __v;
            }
        }

        public static class ProductsImageBean {
            private String product_img;

            public String getProduct_img() {
                return product_img;
            }

            public void setProduct_img(String product_img) {
                this.product_img = product_img;
            }
        }
    }
}
