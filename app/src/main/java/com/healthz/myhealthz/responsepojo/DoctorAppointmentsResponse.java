package com.healthz.myhealthz.responsepojo;

import java.util.List;

public class DoctorAppointmentsResponse {


    /**
     * Status : Success
     * Message : New Appointment List
     * Data : [{"doc_attched":[],"doc_business_info":[{"education_details":[{"education":"BDS","year":"2021"}],"experience_details":[{"company":"Maddy Sam solutions","from":"2021","to":"2021","yearsofexperience":1}],"specialization":[{"specialization":"General Consultant"},{"specialization":"Virology"},{"specialization":"Pathology"},{"specialization":"Microbiology"},{"specialization":"Theriogenology"},{"specialization":"Internal Medicine"},{"specialization":"Behavior"},{"specialization":"Radiation Oncology"},{"specialization":"Equine Medicine"},{"specialization":"XYZ"},{"specialization":"Emergency Services"},{"specialization":"Dermitology"},{"specialization":"Medicinal Specialist"},{"specialization":"KARNATAKA"}],"pet_handled":[{"pet_handled":""}],"clinic_pic":[{"clinic_pic":"http://54.212.108.156:3000/api/uploads/1630922753940.jpg"}],"certificate_pic":[{"certificate_pic":"http://54.212.108.156:3000/api/uploads/1630922761338.pdf"}],"govt_id_pic":[{"govt_id_pic":"http://54.212.108.156:3000/api/uploads/1630922771614.pdf"}],"photo_id_pic":[{"photo_id_pic":"http://54.212.108.156:3000/api/uploads/1630923121570.pdf"}],"_id":"6135e98190b45623fcf93a61","user_id":"6135e70590b45623fcf93a60","dr_title":"Dr","dr_name":"Maddy Sam","clinic_name":"Maddy Sam","clinic_loc":"Salem 103, Vmr Theatre Back Side Rd, Shevapet, Salem, Tamil Nadu 636002, India","clinic_lat":11.6616914,"clinic_long":78.1376186,"thumbnail_image":"","profile_status":true,"profile_verification_status":"Verified","slot_type":"","date_and_time":"06/09/2021 03:42:09","signature":"http://54.212.108.156:3000/api/uploads/1630923134431.jpg","mobile_type":"Android","communication_type":"Online Or Visit","live_status":"Not Live","live_by":"","delete_status":false,"consultancy_fees":200,"calender_status":true,"comments":0,"rating":5,"doctor_exp":1,"updatedAt":"2021-09-06T10:27:35.721Z","createdAt":"2021-09-06T10:12:17.175Z","__v":0}],"_id":"6135eee890b45623fcf93a64","doctor_id":{"_id":"6135e70590b45623fcf93a60","first_name":"Maddy","last_name":"Sam","user_email":"maddysan65@gmail.com","user_phone":"8081828384","date_of_reg":"06/09/2021 03:31 PM","user_type":4,"ref_code":"","my_ref_code":"2F2070N","user_status":"complete","otp":123456,"profile_img":"","user_email_verification":false,"fb_token":"","device_id":"","device_type":"","mobile_type":"Android","delete_status":false,"updatedAt":"2021-09-06T10:36:00.930Z","createdAt":"2021-09-06T10:01:41.700Z","__v":0},"appointment_UID":"PET-1630924520977","booking_date":"07-09-2021","booking_time":"08:30 AM","booking_date_time":"07-09-2021 08:30 AM","communication_type":"Online","msg_id":"Meeting_id/6135eee890b45623fcf93a64","video_id":"https://meet.jit.si/6135eee890b45623fcf93a64","user_id":{"_id":"6131dc387fcc57715cde80d7","first_name":"Sam","last_name":"San","user_email":"samsan@gmail.com","user_phone":"9601960222","date_of_reg":"03/09/2021 01:56 PM","user_type":1,"ref_code":"","my_ref_code":"VU7RPCV","user_status":"complete","otp":123456,"profile_img":"","user_email_verification":false,"fb_token":"","device_id":"","device_type":"","mobile_type":"Android","delete_status":false,"updatedAt":"2021-09-06T10:33:02.024Z","createdAt":"2021-09-03T08:26:32.720Z","__v":0},"patient_id":{"pic":[{"image":"http://54.212.108.156:3000/api/uploads/1630657833829.jpg"}],"_id":"6131dd2e7fcc57715cde80d8","user_id":"6131dc387fcc57715cde80d7","relation":"children","name":"Sam","gender":"Male","age":26,"height":"5","weight":"60","anymedicalinfo":"no comments","delete_status":false,"createdAt":"2021-09-03T08:30:38.939Z","updatedAt":"2021-09-03T08:30:38.939Z","__v":0},"problem_info":"no comments","appoinment_status":"Incomplete","start_appointment_status":"Not Started","end_appointment_status":"Not End","doc_feedback":"","doc_rate":"","user_feedback":"","user_rate":"0","display_date":"2021-09-07 08:30:00","server_date_time":"","payment_method":"Online","prescription_details":"","vaccination_details":"","appointment_types":"Normal","allergies":"no","payment_id":"pay_Hu9FrwOV4rJRqY","amount":"200","service_name":"","service_amount":"","completed_at":"","missed_at":"","mobile_type":"Android","delete_status":false,"appoint_patient_st":"","date_and_time":"06-09-2021 04:03 PM","pervious_app_date":"","reshedule_status":"","location_id":"","visit_type":"","doctor_comment":"","diagnosis":"","sub_diagnosis":"","health_issue_title":"General Checkup","updatedAt":"2021-09-06T10:35:20.989Z","createdAt":"2021-09-06T10:35:20.983Z","__v":0}]
     * Code : 200
     */

    private String Status;
    private String Message;
    private int Code;
    /**
     * doc_attched : []
     * doc_business_info : [{"education_details":[{"education":"BDS","year":"2021"}],"experience_details":[{"company":"Maddy Sam solutions","from":"2021","to":"2021","yearsofexperience":1}],"specialization":[{"specialization":"General Consultant"},{"specialization":"Virology"},{"specialization":"Pathology"},{"specialization":"Microbiology"},{"specialization":"Theriogenology"},{"specialization":"Internal Medicine"},{"specialization":"Behavior"},{"specialization":"Radiation Oncology"},{"specialization":"Equine Medicine"},{"specialization":"XYZ"},{"specialization":"Emergency Services"},{"specialization":"Dermitology"},{"specialization":"Medicinal Specialist"},{"specialization":"KARNATAKA"}],"pet_handled":[{"pet_handled":""}],"clinic_pic":[{"clinic_pic":"http://54.212.108.156:3000/api/uploads/1630922753940.jpg"}],"certificate_pic":[{"certificate_pic":"http://54.212.108.156:3000/api/uploads/1630922761338.pdf"}],"govt_id_pic":[{"govt_id_pic":"http://54.212.108.156:3000/api/uploads/1630922771614.pdf"}],"photo_id_pic":[{"photo_id_pic":"http://54.212.108.156:3000/api/uploads/1630923121570.pdf"}],"_id":"6135e98190b45623fcf93a61","user_id":"6135e70590b45623fcf93a60","dr_title":"Dr","dr_name":"Maddy Sam","clinic_name":"Maddy Sam","clinic_loc":"Salem 103, Vmr Theatre Back Side Rd, Shevapet, Salem, Tamil Nadu 636002, India","clinic_lat":11.6616914,"clinic_long":78.1376186,"thumbnail_image":"","profile_status":true,"profile_verification_status":"Verified","slot_type":"","date_and_time":"06/09/2021 03:42:09","signature":"http://54.212.108.156:3000/api/uploads/1630923134431.jpg","mobile_type":"Android","communication_type":"Online Or Visit","live_status":"Not Live","live_by":"","delete_status":false,"consultancy_fees":200,"calender_status":true,"comments":0,"rating":5,"doctor_exp":1,"updatedAt":"2021-09-06T10:27:35.721Z","createdAt":"2021-09-06T10:12:17.175Z","__v":0}]
     * _id : 6135eee890b45623fcf93a64
     * doctor_id : {"_id":"6135e70590b45623fcf93a60","first_name":"Maddy","last_name":"Sam","user_email":"maddysan65@gmail.com","user_phone":"8081828384","date_of_reg":"06/09/2021 03:31 PM","user_type":4,"ref_code":"","my_ref_code":"2F2070N","user_status":"complete","otp":123456,"profile_img":"","user_email_verification":false,"fb_token":"","device_id":"","device_type":"","mobile_type":"Android","delete_status":false,"updatedAt":"2021-09-06T10:36:00.930Z","createdAt":"2021-09-06T10:01:41.700Z","__v":0}
     * appointment_UID : PET-1630924520977
     * booking_date : 07-09-2021
     * booking_time : 08:30 AM
     * booking_date_time : 07-09-2021 08:30 AM
     * communication_type : Online
     * msg_id : Meeting_id/6135eee890b45623fcf93a64
     * video_id : https://meet.jit.si/6135eee890b45623fcf93a64
     * user_id : {"_id":"6131dc387fcc57715cde80d7","first_name":"Sam","last_name":"San","user_email":"samsan@gmail.com","user_phone":"9601960222","date_of_reg":"03/09/2021 01:56 PM","user_type":1,"ref_code":"","my_ref_code":"VU7RPCV","user_status":"complete","otp":123456,"profile_img":"","user_email_verification":false,"fb_token":"","device_id":"","device_type":"","mobile_type":"Android","delete_status":false,"updatedAt":"2021-09-06T10:33:02.024Z","createdAt":"2021-09-03T08:26:32.720Z","__v":0}
     * patient_id : {"pic":[{"image":"http://54.212.108.156:3000/api/uploads/1630657833829.jpg"}],"_id":"6131dd2e7fcc57715cde80d8","user_id":"6131dc387fcc57715cde80d7","relation":"children","name":"Sam","gender":"Male","age":26,"height":"5","weight":"60","anymedicalinfo":"no comments","delete_status":false,"createdAt":"2021-09-03T08:30:38.939Z","updatedAt":"2021-09-03T08:30:38.939Z","__v":0}
     * problem_info : no comments
     * appoinment_status : Incomplete
     * start_appointment_status : Not Started
     * end_appointment_status : Not End
     * doc_feedback :
     * doc_rate :
     * user_feedback :
     * user_rate : 0
     * display_date : 2021-09-07 08:30:00
     * server_date_time :
     * payment_method : Online
     * prescription_details :
     * vaccination_details :
     * appointment_types : Normal
     * allergies : no
     * payment_id : pay_Hu9FrwOV4rJRqY
     * amount : 200
     * service_name :
     * service_amount :
     * completed_at :
     * missed_at :
     * mobile_type : Android
     * delete_status : false
     * appoint_patient_st :
     * date_and_time : 06-09-2021 04:03 PM
     * pervious_app_date :
     * reshedule_status :
     * location_id :
     * visit_type :
     * doctor_comment :
     * diagnosis :
     * sub_diagnosis :
     * health_issue_title : General Checkup
     * updatedAt : 2021-09-06T10:35:20.989Z
     * createdAt : 2021-09-06T10:35:20.983Z
     * __v : 0
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
        private String _id;
        /**
         * _id : 6135e70590b45623fcf93a60
         * first_name : Maddy
         * last_name : Sam
         * user_email : maddysan65@gmail.com
         * user_phone : 8081828384
         * date_of_reg : 06/09/2021 03:31 PM
         * user_type : 4
         * ref_code :
         * my_ref_code : 2F2070N
         * user_status : complete
         * otp : 123456
         * profile_img :
         * user_email_verification : false
         * fb_token :
         * device_id :
         * device_type :
         * mobile_type : Android
         * delete_status : false
         * updatedAt : 2021-09-06T10:36:00.930Z
         * createdAt : 2021-09-06T10:01:41.700Z
         * __v : 0
         */

        private DoctorIdBean doctor_id;
        private String appointment_UID;
        private String booking_date;
        private String booking_time;
        private String booking_date_time;
        private String communication_type;
        private String msg_id;
        private String video_id;
        /**
         * _id : 6131dc387fcc57715cde80d7
         * first_name : Sam
         * last_name : San
         * user_email : samsan@gmail.com
         * user_phone : 9601960222
         * date_of_reg : 03/09/2021 01:56 PM
         * user_type : 1
         * ref_code :
         * my_ref_code : VU7RPCV
         * user_status : complete
         * otp : 123456
         * profile_img :
         * user_email_verification : false
         * fb_token :
         * device_id :
         * device_type :
         * mobile_type : Android
         * delete_status : false
         * updatedAt : 2021-09-06T10:33:02.024Z
         * createdAt : 2021-09-03T08:26:32.720Z
         * __v : 0
         */

        private UserIdBean user_id;
        /**
         * pic : [{"image":"http://54.212.108.156:3000/api/uploads/1630657833829.jpg"}]
         * _id : 6131dd2e7fcc57715cde80d8
         * user_id : 6131dc387fcc57715cde80d7
         * relation : children
         * name : Sam
         * gender : Male
         * age : 26
         * height : 5
         * weight : 60
         * anymedicalinfo : no comments
         * delete_status : false
         * createdAt : 2021-09-03T08:30:38.939Z
         * updatedAt : 2021-09-03T08:30:38.939Z
         * __v : 0
         */

        private PatientIdBean patient_id;
        private String problem_info;
        private String appoinment_status;
        private String start_appointment_status;
        private String end_appointment_status;
        private String doc_feedback;
        private String doc_rate;
        private String user_feedback;
        private String user_rate;
        private String display_date;
        private String server_date_time;
        private String payment_method;
        private String prescription_details;
        private String vaccination_details;
        private String appointment_types;
        private String allergies;
        private String payment_id;
        private String amount;
        private String service_name;
        private String service_amount;
        private String completed_at;
        private String missed_at;
        private String mobile_type;
        private boolean delete_status;
        private String appoint_patient_st;
        private String date_and_time;
        private String pervious_app_date;
        private String reshedule_status;
        private String location_id;
        private String visit_type;
        private String doctor_comment;
        private String diagnosis;
        private String sub_diagnosis;
        private String health_issue_title;
        private String updatedAt;
        private String createdAt;
        private int __v;
        private List<?> doc_attched;
        /**
         * education_details : [{"education":"BDS","year":"2021"}]
         * experience_details : [{"company":"Maddy Sam solutions","from":"2021","to":"2021","yearsofexperience":1}]
         * specialization : [{"specialization":"General Consultant"},{"specialization":"Virology"},{"specialization":"Pathology"},{"specialization":"Microbiology"},{"specialization":"Theriogenology"},{"specialization":"Internal Medicine"},{"specialization":"Behavior"},{"specialization":"Radiation Oncology"},{"specialization":"Equine Medicine"},{"specialization":"XYZ"},{"specialization":"Emergency Services"},{"specialization":"Dermitology"},{"specialization":"Medicinal Specialist"},{"specialization":"KARNATAKA"}]
         * pet_handled : [{"pet_handled":""}]
         * clinic_pic : [{"clinic_pic":"http://54.212.108.156:3000/api/uploads/1630922753940.jpg"}]
         * certificate_pic : [{"certificate_pic":"http://54.212.108.156:3000/api/uploads/1630922761338.pdf"}]
         * govt_id_pic : [{"govt_id_pic":"http://54.212.108.156:3000/api/uploads/1630922771614.pdf"}]
         * photo_id_pic : [{"photo_id_pic":"http://54.212.108.156:3000/api/uploads/1630923121570.pdf"}]
         * _id : 6135e98190b45623fcf93a61
         * user_id : 6135e70590b45623fcf93a60
         * dr_title : Dr
         * dr_name : Maddy Sam
         * clinic_name : Maddy Sam
         * clinic_loc : Salem 103, Vmr Theatre Back Side Rd, Shevapet, Salem, Tamil Nadu 636002, India
         * clinic_lat : 11.6616914
         * clinic_long : 78.1376186
         * thumbnail_image :
         * profile_status : true
         * profile_verification_status : Verified
         * slot_type :
         * date_and_time : 06/09/2021 03:42:09
         * signature : http://54.212.108.156:3000/api/uploads/1630923134431.jpg
         * mobile_type : Android
         * communication_type : Online Or Visit
         * live_status : Not Live
         * live_by :
         * delete_status : false
         * consultancy_fees : 200
         * calender_status : true
         * comments : 0
         * rating : 5
         * doctor_exp : 1
         * updatedAt : 2021-09-06T10:27:35.721Z
         * createdAt : 2021-09-06T10:12:17.175Z
         * __v : 0
         */

        private List<DocBusinessInfoBean> doc_business_info;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public DoctorIdBean getDoctor_id() {
            return doctor_id;
        }

        public void setDoctor_id(DoctorIdBean doctor_id) {
            this.doctor_id = doctor_id;
        }

        public String getAppointment_UID() {
            return appointment_UID;
        }

        public void setAppointment_UID(String appointment_UID) {
            this.appointment_UID = appointment_UID;
        }

        public String getBooking_date() {
            return booking_date;
        }

        public void setBooking_date(String booking_date) {
            this.booking_date = booking_date;
        }

        public String getBooking_time() {
            return booking_time;
        }

        public void setBooking_time(String booking_time) {
            this.booking_time = booking_time;
        }

        public String getBooking_date_time() {
            return booking_date_time;
        }

        public void setBooking_date_time(String booking_date_time) {
            this.booking_date_time = booking_date_time;
        }

        public String getCommunication_type() {
            return communication_type;
        }

        public void setCommunication_type(String communication_type) {
            this.communication_type = communication_type;
        }

        public String getMsg_id() {
            return msg_id;
        }

        public void setMsg_id(String msg_id) {
            this.msg_id = msg_id;
        }

        public String getVideo_id() {
            return video_id;
        }

        public void setVideo_id(String video_id) {
            this.video_id = video_id;
        }

        public UserIdBean getUser_id() {
            return user_id;
        }

        public void setUser_id(UserIdBean user_id) {
            this.user_id = user_id;
        }

        public PatientIdBean getPatient_id() {
            return patient_id;
        }

        public void setPatient_id(PatientIdBean patient_id) {
            this.patient_id = patient_id;
        }

        public String getProblem_info() {
            return problem_info;
        }

        public void setProblem_info(String problem_info) {
            this.problem_info = problem_info;
        }

        public String getAppoinment_status() {
            return appoinment_status;
        }

        public void setAppoinment_status(String appoinment_status) {
            this.appoinment_status = appoinment_status;
        }

        public String getStart_appointment_status() {
            return start_appointment_status;
        }

        public void setStart_appointment_status(String start_appointment_status) {
            this.start_appointment_status = start_appointment_status;
        }

        public String getEnd_appointment_status() {
            return end_appointment_status;
        }

        public void setEnd_appointment_status(String end_appointment_status) {
            this.end_appointment_status = end_appointment_status;
        }

        public String getDoc_feedback() {
            return doc_feedback;
        }

        public void setDoc_feedback(String doc_feedback) {
            this.doc_feedback = doc_feedback;
        }

        public String getDoc_rate() {
            return doc_rate;
        }

        public void setDoc_rate(String doc_rate) {
            this.doc_rate = doc_rate;
        }

        public String getUser_feedback() {
            return user_feedback;
        }

        public void setUser_feedback(String user_feedback) {
            this.user_feedback = user_feedback;
        }

        public String getUser_rate() {
            return user_rate;
        }

        public void setUser_rate(String user_rate) {
            this.user_rate = user_rate;
        }

        public String getDisplay_date() {
            return display_date;
        }

        public void setDisplay_date(String display_date) {
            this.display_date = display_date;
        }

        public String getServer_date_time() {
            return server_date_time;
        }

        public void setServer_date_time(String server_date_time) {
            this.server_date_time = server_date_time;
        }

        public String getPayment_method() {
            return payment_method;
        }

        public void setPayment_method(String payment_method) {
            this.payment_method = payment_method;
        }

        public String getPrescription_details() {
            return prescription_details;
        }

        public void setPrescription_details(String prescription_details) {
            this.prescription_details = prescription_details;
        }

        public String getVaccination_details() {
            return vaccination_details;
        }

        public void setVaccination_details(String vaccination_details) {
            this.vaccination_details = vaccination_details;
        }

        public String getAppointment_types() {
            return appointment_types;
        }

        public void setAppointment_types(String appointment_types) {
            this.appointment_types = appointment_types;
        }

        public String getAllergies() {
            return allergies;
        }

        public void setAllergies(String allergies) {
            this.allergies = allergies;
        }

        public String getPayment_id() {
            return payment_id;
        }

        public void setPayment_id(String payment_id) {
            this.payment_id = payment_id;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getService_name() {
            return service_name;
        }

        public void setService_name(String service_name) {
            this.service_name = service_name;
        }

        public String getService_amount() {
            return service_amount;
        }

        public void setService_amount(String service_amount) {
            this.service_amount = service_amount;
        }

        public String getCompleted_at() {
            return completed_at;
        }

        public void setCompleted_at(String completed_at) {
            this.completed_at = completed_at;
        }

        public String getMissed_at() {
            return missed_at;
        }

        public void setMissed_at(String missed_at) {
            this.missed_at = missed_at;
        }

        public String getMobile_type() {
            return mobile_type;
        }

        public void setMobile_type(String mobile_type) {
            this.mobile_type = mobile_type;
        }

        public boolean isDelete_status() {
            return delete_status;
        }

        public void setDelete_status(boolean delete_status) {
            this.delete_status = delete_status;
        }

        public String getAppoint_patient_st() {
            return appoint_patient_st;
        }

        public void setAppoint_patient_st(String appoint_patient_st) {
            this.appoint_patient_st = appoint_patient_st;
        }

        public String getDate_and_time() {
            return date_and_time;
        }

        public void setDate_and_time(String date_and_time) {
            this.date_and_time = date_and_time;
        }

        public String getPervious_app_date() {
            return pervious_app_date;
        }

        public void setPervious_app_date(String pervious_app_date) {
            this.pervious_app_date = pervious_app_date;
        }

        public String getReshedule_status() {
            return reshedule_status;
        }

        public void setReshedule_status(String reshedule_status) {
            this.reshedule_status = reshedule_status;
        }

        public String getLocation_id() {
            return location_id;
        }

        public void setLocation_id(String location_id) {
            this.location_id = location_id;
        }

        public String getVisit_type() {
            return visit_type;
        }

        public void setVisit_type(String visit_type) {
            this.visit_type = visit_type;
        }

        public String getDoctor_comment() {
            return doctor_comment;
        }

        public void setDoctor_comment(String doctor_comment) {
            this.doctor_comment = doctor_comment;
        }

        public String getDiagnosis() {
            return diagnosis;
        }

        public void setDiagnosis(String diagnosis) {
            this.diagnosis = diagnosis;
        }

        public String getSub_diagnosis() {
            return sub_diagnosis;
        }

        public void setSub_diagnosis(String sub_diagnosis) {
            this.sub_diagnosis = sub_diagnosis;
        }

        public String getHealth_issue_title() {
            return health_issue_title;
        }

        public void setHealth_issue_title(String health_issue_title) {
            this.health_issue_title = health_issue_title;
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

        public List<?> getDoc_attched() {
            return doc_attched;
        }

        public void setDoc_attched(List<?> doc_attched) {
            this.doc_attched = doc_attched;
        }

        public List<DocBusinessInfoBean> getDoc_business_info() {
            return doc_business_info;
        }

        public void setDoc_business_info(List<DocBusinessInfoBean> doc_business_info) {
            this.doc_business_info = doc_business_info;
        }

        public static class DoctorIdBean {
            private String _id;
            private String first_name;
            private String last_name;
            private String user_email;
            private String user_phone;
            private String date_of_reg;
            private int user_type;
            private String ref_code;
            private String my_ref_code;
            private String user_status;
            private int otp;
            private String profile_img;
            private boolean user_email_verification;
            private String fb_token;
            private String device_id;
            private String device_type;
            private String mobile_type;
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

            public String getFirst_name() {
                return first_name;
            }

            public void setFirst_name(String first_name) {
                this.first_name = first_name;
            }

            public String getLast_name() {
                return last_name;
            }

            public void setLast_name(String last_name) {
                this.last_name = last_name;
            }

            public String getUser_email() {
                return user_email;
            }

            public void setUser_email(String user_email) {
                this.user_email = user_email;
            }

            public String getUser_phone() {
                return user_phone;
            }

            public void setUser_phone(String user_phone) {
                this.user_phone = user_phone;
            }

            public String getDate_of_reg() {
                return date_of_reg;
            }

            public void setDate_of_reg(String date_of_reg) {
                this.date_of_reg = date_of_reg;
            }

            public int getUser_type() {
                return user_type;
            }

            public void setUser_type(int user_type) {
                this.user_type = user_type;
            }

            public String getRef_code() {
                return ref_code;
            }

            public void setRef_code(String ref_code) {
                this.ref_code = ref_code;
            }

            public String getMy_ref_code() {
                return my_ref_code;
            }

            public void setMy_ref_code(String my_ref_code) {
                this.my_ref_code = my_ref_code;
            }

            public String getUser_status() {
                return user_status;
            }

            public void setUser_status(String user_status) {
                this.user_status = user_status;
            }

            public int getOtp() {
                return otp;
            }

            public void setOtp(int otp) {
                this.otp = otp;
            }

            public String getProfile_img() {
                return profile_img;
            }

            public void setProfile_img(String profile_img) {
                this.profile_img = profile_img;
            }

            public boolean isUser_email_verification() {
                return user_email_verification;
            }

            public void setUser_email_verification(boolean user_email_verification) {
                this.user_email_verification = user_email_verification;
            }

            public String getFb_token() {
                return fb_token;
            }

            public void setFb_token(String fb_token) {
                this.fb_token = fb_token;
            }

            public String getDevice_id() {
                return device_id;
            }

            public void setDevice_id(String device_id) {
                this.device_id = device_id;
            }

            public String getDevice_type() {
                return device_type;
            }

            public void setDevice_type(String device_type) {
                this.device_type = device_type;
            }

            public String getMobile_type() {
                return mobile_type;
            }

            public void setMobile_type(String mobile_type) {
                this.mobile_type = mobile_type;
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

        public static class UserIdBean {
            private String _id;
            private String first_name;
            private String last_name;
            private String user_email;
            private String user_phone;
            private String date_of_reg;
            private int user_type;
            private String ref_code;
            private String my_ref_code;
            private String user_status;
            private int otp;
            private String profile_img;
            private boolean user_email_verification;
            private String fb_token;
            private String device_id;
            private String device_type;
            private String mobile_type;
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

            public String getFirst_name() {
                return first_name;
            }

            public void setFirst_name(String first_name) {
                this.first_name = first_name;
            }

            public String getLast_name() {
                return last_name;
            }

            public void setLast_name(String last_name) {
                this.last_name = last_name;
            }

            public String getUser_email() {
                return user_email;
            }

            public void setUser_email(String user_email) {
                this.user_email = user_email;
            }

            public String getUser_phone() {
                return user_phone;
            }

            public void setUser_phone(String user_phone) {
                this.user_phone = user_phone;
            }

            public String getDate_of_reg() {
                return date_of_reg;
            }

            public void setDate_of_reg(String date_of_reg) {
                this.date_of_reg = date_of_reg;
            }

            public int getUser_type() {
                return user_type;
            }

            public void setUser_type(int user_type) {
                this.user_type = user_type;
            }

            public String getRef_code() {
                return ref_code;
            }

            public void setRef_code(String ref_code) {
                this.ref_code = ref_code;
            }

            public String getMy_ref_code() {
                return my_ref_code;
            }

            public void setMy_ref_code(String my_ref_code) {
                this.my_ref_code = my_ref_code;
            }

            public String getUser_status() {
                return user_status;
            }

            public void setUser_status(String user_status) {
                this.user_status = user_status;
            }

            public int getOtp() {
                return otp;
            }

            public void setOtp(int otp) {
                this.otp = otp;
            }

            public String getProfile_img() {
                return profile_img;
            }

            public void setProfile_img(String profile_img) {
                this.profile_img = profile_img;
            }

            public boolean isUser_email_verification() {
                return user_email_verification;
            }

            public void setUser_email_verification(boolean user_email_verification) {
                this.user_email_verification = user_email_verification;
            }

            public String getFb_token() {
                return fb_token;
            }

            public void setFb_token(String fb_token) {
                this.fb_token = fb_token;
            }

            public String getDevice_id() {
                return device_id;
            }

            public void setDevice_id(String device_id) {
                this.device_id = device_id;
            }

            public String getDevice_type() {
                return device_type;
            }

            public void setDevice_type(String device_type) {
                this.device_type = device_type;
            }

            public String getMobile_type() {
                return mobile_type;
            }

            public void setMobile_type(String mobile_type) {
                this.mobile_type = mobile_type;
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

        public static class PatientIdBean {
            private String _id;
            private String user_id;
            private String relation;
            private String name;
            private String gender;
            private int age;
            private String height;
            private String weight;
            private String anymedicalinfo;
            private boolean delete_status;
            private String createdAt;
            private String updatedAt;
            private int __v;
            /**
             * image : http://54.212.108.156:3000/api/uploads/1630657833829.jpg
             */

            private List<PicBean> pic;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getRelation() {
                return relation;
            }

            public void setRelation(String relation) {
                this.relation = relation;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getGender() {
                return gender;
            }

            public void setGender(String gender) {
                this.gender = gender;
            }

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }

            public String getHeight() {
                return height;
            }

            public void setHeight(String height) {
                this.height = height;
            }

            public String getWeight() {
                return weight;
            }

            public void setWeight(String weight) {
                this.weight = weight;
            }

            public String getAnymedicalinfo() {
                return anymedicalinfo;
            }

            public void setAnymedicalinfo(String anymedicalinfo) {
                this.anymedicalinfo = anymedicalinfo;
            }

            public boolean isDelete_status() {
                return delete_status;
            }

            public void setDelete_status(boolean delete_status) {
                this.delete_status = delete_status;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getUpdatedAt() {
                return updatedAt;
            }

            public void setUpdatedAt(String updatedAt) {
                this.updatedAt = updatedAt;
            }

            public int get__v() {
                return __v;
            }

            public void set__v(int __v) {
                this.__v = __v;
            }

            public List<PicBean> getPic() {
                return pic;
            }

            public void setPic(List<PicBean> pic) {
                this.pic = pic;
            }

            public static class PicBean {
                private String image;

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }
            }
        }

        public static class DocBusinessInfoBean {
            private String _id;
            private String user_id;
            private String dr_title;
            private String dr_name;
            private String clinic_name;
            private String clinic_loc;
            private double clinic_lat;
            private double clinic_long;
            private String thumbnail_image;
            private boolean profile_status;
            private String profile_verification_status;
            private String slot_type;
            private String date_and_time;
            private String signature;
            private String mobile_type;
            private String communication_type;
            private String live_status;
            private String live_by;
            private boolean delete_status;
            private int consultancy_fees;
            private boolean calender_status;
            private int comments;
            private int rating;
            private int doctor_exp;
            private String updatedAt;
            private String createdAt;
            private int __v;
            /**
             * education : BDS
             * year : 2021
             */

            private List<EducationDetailsBean> education_details;
            /**
             * company : Maddy Sam solutions
             * from : 2021
             * to : 2021
             * yearsofexperience : 1
             */

            private List<ExperienceDetailsBean> experience_details;
            /**
             * specialization : General Consultant
             */

            private List<SpecializationBean> specialization;
            /**
             * pet_handled :
             */

            private List<PetHandledBean> pet_handled;
            /**
             * clinic_pic : http://54.212.108.156:3000/api/uploads/1630922753940.jpg
             */

            private List<ClinicPicBean> clinic_pic;
            /**
             * certificate_pic : http://54.212.108.156:3000/api/uploads/1630922761338.pdf
             */

            private List<CertificatePicBean> certificate_pic;
            /**
             * govt_id_pic : http://54.212.108.156:3000/api/uploads/1630922771614.pdf
             */

            private List<GovtIdPicBean> govt_id_pic;
            /**
             * photo_id_pic : http://54.212.108.156:3000/api/uploads/1630923121570.pdf
             */

            private List<PhotoIdPicBean> photo_id_pic;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getDr_title() {
                return dr_title;
            }

            public void setDr_title(String dr_title) {
                this.dr_title = dr_title;
            }

            public String getDr_name() {
                return dr_name;
            }

            public void setDr_name(String dr_name) {
                this.dr_name = dr_name;
            }

            public String getClinic_name() {
                return clinic_name;
            }

            public void setClinic_name(String clinic_name) {
                this.clinic_name = clinic_name;
            }

            public String getClinic_loc() {
                return clinic_loc;
            }

            public void setClinic_loc(String clinic_loc) {
                this.clinic_loc = clinic_loc;
            }

            public double getClinic_lat() {
                return clinic_lat;
            }

            public void setClinic_lat(double clinic_lat) {
                this.clinic_lat = clinic_lat;
            }

            public double getClinic_long() {
                return clinic_long;
            }

            public void setClinic_long(double clinic_long) {
                this.clinic_long = clinic_long;
            }

            public String getThumbnail_image() {
                return thumbnail_image;
            }

            public void setThumbnail_image(String thumbnail_image) {
                this.thumbnail_image = thumbnail_image;
            }

            public boolean isProfile_status() {
                return profile_status;
            }

            public void setProfile_status(boolean profile_status) {
                this.profile_status = profile_status;
            }

            public String getProfile_verification_status() {
                return profile_verification_status;
            }

            public void setProfile_verification_status(String profile_verification_status) {
                this.profile_verification_status = profile_verification_status;
            }

            public String getSlot_type() {
                return slot_type;
            }

            public void setSlot_type(String slot_type) {
                this.slot_type = slot_type;
            }

            public String getDate_and_time() {
                return date_and_time;
            }

            public void setDate_and_time(String date_and_time) {
                this.date_and_time = date_and_time;
            }

            public String getSignature() {
                return signature;
            }

            public void setSignature(String signature) {
                this.signature = signature;
            }

            public String getMobile_type() {
                return mobile_type;
            }

            public void setMobile_type(String mobile_type) {
                this.mobile_type = mobile_type;
            }

            public String getCommunication_type() {
                return communication_type;
            }

            public void setCommunication_type(String communication_type) {
                this.communication_type = communication_type;
            }

            public String getLive_status() {
                return live_status;
            }

            public void setLive_status(String live_status) {
                this.live_status = live_status;
            }

            public String getLive_by() {
                return live_by;
            }

            public void setLive_by(String live_by) {
                this.live_by = live_by;
            }

            public boolean isDelete_status() {
                return delete_status;
            }

            public void setDelete_status(boolean delete_status) {
                this.delete_status = delete_status;
            }

            public int getConsultancy_fees() {
                return consultancy_fees;
            }

            public void setConsultancy_fees(int consultancy_fees) {
                this.consultancy_fees = consultancy_fees;
            }

            public boolean isCalender_status() {
                return calender_status;
            }

            public void setCalender_status(boolean calender_status) {
                this.calender_status = calender_status;
            }

            public int getComments() {
                return comments;
            }

            public void setComments(int comments) {
                this.comments = comments;
            }

            public int getRating() {
                return rating;
            }

            public void setRating(int rating) {
                this.rating = rating;
            }

            public int getDoctor_exp() {
                return doctor_exp;
            }

            public void setDoctor_exp(int doctor_exp) {
                this.doctor_exp = doctor_exp;
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

            public List<EducationDetailsBean> getEducation_details() {
                return education_details;
            }

            public void setEducation_details(List<EducationDetailsBean> education_details) {
                this.education_details = education_details;
            }

            public List<ExperienceDetailsBean> getExperience_details() {
                return experience_details;
            }

            public void setExperience_details(List<ExperienceDetailsBean> experience_details) {
                this.experience_details = experience_details;
            }

            public List<SpecializationBean> getSpecialization() {
                return specialization;
            }

            public void setSpecialization(List<SpecializationBean> specialization) {
                this.specialization = specialization;
            }

            public List<PetHandledBean> getPet_handled() {
                return pet_handled;
            }

            public void setPet_handled(List<PetHandledBean> pet_handled) {
                this.pet_handled = pet_handled;
            }

            public List<ClinicPicBean> getClinic_pic() {
                return clinic_pic;
            }

            public void setClinic_pic(List<ClinicPicBean> clinic_pic) {
                this.clinic_pic = clinic_pic;
            }

            public List<CertificatePicBean> getCertificate_pic() {
                return certificate_pic;
            }

            public void setCertificate_pic(List<CertificatePicBean> certificate_pic) {
                this.certificate_pic = certificate_pic;
            }

            public List<GovtIdPicBean> getGovt_id_pic() {
                return govt_id_pic;
            }

            public void setGovt_id_pic(List<GovtIdPicBean> govt_id_pic) {
                this.govt_id_pic = govt_id_pic;
            }

            public List<PhotoIdPicBean> getPhoto_id_pic() {
                return photo_id_pic;
            }

            public void setPhoto_id_pic(List<PhotoIdPicBean> photo_id_pic) {
                this.photo_id_pic = photo_id_pic;
            }

            public static class EducationDetailsBean {
                private String education;
                private String year;

                public String getEducation() {
                    return education;
                }

                public void setEducation(String education) {
                    this.education = education;
                }

                public String getYear() {
                    return year;
                }

                public void setYear(String year) {
                    this.year = year;
                }
            }

            public static class ExperienceDetailsBean {
                private String company;
                private String from;
                private String to;
                private int yearsofexperience;

                public String getCompany() {
                    return company;
                }

                public void setCompany(String company) {
                    this.company = company;
                }

                public String getFrom() {
                    return from;
                }

                public void setFrom(String from) {
                    this.from = from;
                }

                public String getTo() {
                    return to;
                }

                public void setTo(String to) {
                    this.to = to;
                }

                public int getYearsofexperience() {
                    return yearsofexperience;
                }

                public void setYearsofexperience(int yearsofexperience) {
                    this.yearsofexperience = yearsofexperience;
                }
            }

            public static class SpecializationBean {
                private String specialization;

                public String getSpecialization() {
                    return specialization;
                }

                public void setSpecialization(String specialization) {
                    this.specialization = specialization;
                }
            }

            public static class PetHandledBean {
                private String pet_handled;

                public String getPet_handled() {
                    return pet_handled;
                }

                public void setPet_handled(String pet_handled) {
                    this.pet_handled = pet_handled;
                }
            }

            public static class ClinicPicBean {
                private String clinic_pic;

                public String getClinic_pic() {
                    return clinic_pic;
                }

                public void setClinic_pic(String clinic_pic) {
                    this.clinic_pic = clinic_pic;
                }
            }

            public static class CertificatePicBean {
                private String certificate_pic;

                public String getCertificate_pic() {
                    return certificate_pic;
                }

                public void setCertificate_pic(String certificate_pic) {
                    this.certificate_pic = certificate_pic;
                }
            }

            public static class GovtIdPicBean {
                private String govt_id_pic;

                public String getGovt_id_pic() {
                    return govt_id_pic;
                }

                public void setGovt_id_pic(String govt_id_pic) {
                    this.govt_id_pic = govt_id_pic;
                }
            }

            public static class PhotoIdPicBean {
                private String photo_id_pic;

                public String getPhoto_id_pic() {
                    return photo_id_pic;
                }

                public void setPhoto_id_pic(String photo_id_pic) {
                    this.photo_id_pic = photo_id_pic;
                }
            }
        }
    }
}
