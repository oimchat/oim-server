package com.oimchat.server.general.kernel.work.module.base.user.data.dto;

import java.time.LocalDate;

/**
 * 用户信息<br>
 * Date 2019-01-06 12:12:41<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
public class UserData {
	/**
	 * id
	 */
	private String id;
	/**
	 * 数字账号
	 */
	private Long number;
	/**
	 * 帐号
	 */
	private String account;
	/**
	 * 电子邮箱
	 */
	private String email;
	/**
	 * 手机号码
	 */
	private String mobile;
	/**
	 * 密码
	 */
	private String password;

	/********************************************************************************
	 * 基本信息 *
	 ******************************************************************************/
	/**
	 * 系统头像编号
	 */
	private String head;
	/**
	 * 自定义照片，（当用户选择系统头像时为空）
	 */
	private String avatar;
	/**
	 * 昵称
	 */
	private String nickname;
	/**
	 * 真实姓名
	 */
	private String name;
	/**
	 * 姓名的拼写
	 */
	private String spell;
	/**
	 * 姓名的简拼
	 */
	private String simpleSpell;
	/**
	 * 性别 1:男 2：女 3：保密
	 */
	private String gender;
	/**
	 * 联系电话（固定电话）
	 */
	private String telephone;
	/**
	 * 家庭地址
	 */
	private String homeAddress;
	/**
	 * 所在地址
	 */
	private String locationAddress;
	/**
	 * 家庭地邮政编码
	 */
	private String homeZipCode;

	/**
	 * 所在地邮政编码
	 */
	private String locationZipCode;

	/**
	 * 星座
	 */
	private String constellationCode;

	/**
	 * 血型
	 */
	private String blood;

	/**
	 * 出生日期
	 */
	private LocalDate birthDate;

	/**
	 * 年龄
	 */
	private Integer age;

	/**
	 * 身份证号码
	 */
	private String identityCard;

	/**
	 * 婚姻状况: 1:未婚 2:已婚
	 */
	private String maritalStatus;

	/**
	 * 籍贯
	 */
	private String nativePlace;

	/**
	 * 民族
	 */
	private String nationName;

	/**
	 * 政治面貌
	 */
	private String politicsStatus;

	/**
	 * 介绍
	 */
	private String introduce;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * qq号码
	 */
	private String qq;

	/**
	 * 学历
	 */
	private String education;

	/**
	 * 毕业学校
	 */
	private String school;

	/**
	 * 专业
	 */
	private String professional;
	/**
	 * 毕业时间
	 */
	private String graduationDate;
	/**
	 * 参加工作时间
	 */
	private String workDate;

	/**
	 * 个性签名
	 */
	private String signature;
	/**
	 * 是否禁用 0：启用 1：停用
	 */
	private Integer isDisable;
	/**
	 * 注销时间
	 */
	private Long canceledTimestamp;
	/**
	 * 用户类型 0:普通用户 1：管理员用户 2:超级管理员
	 */
	private String type;

	/**
	 * 在线状态
	 */
	private String status;
	/**
	 * 上线时间
	 */
	private Long onlineTimestamp;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpell() {
		return spell;
	}

	public void setSpell(String spell) {
		this.spell = spell;
	}

	public String getSimpleSpell() {
		return simpleSpell;
	}

	public void setSimpleSpell(String simpleSpell) {
		this.simpleSpell = simpleSpell;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getLocationAddress() {
		return locationAddress;
	}

	public void setLocationAddress(String locationAddress) {
		this.locationAddress = locationAddress;
	}

	public String getHomeZipCode() {
		return homeZipCode;
	}

	public void setHomeZipCode(String homeZipCode) {
		this.homeZipCode = homeZipCode;
	}

	public String getLocationZipCode() {
		return locationZipCode;
	}

	public void setLocationZipCode(String locationZipCode) {
		this.locationZipCode = locationZipCode;
	}

	public String getConstellationCode() {
		return constellationCode;
	}

	public void setConstellationCode(String constellationCode) {
		this.constellationCode = constellationCode;
	}

	public String getBlood() {
		return blood;
	}

	public void setBlood(String blood) {
		this.blood = blood;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getIdentityCard() {
		return identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getNativePlace() {
		return nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	public String getNationName() {
		return nationName;
	}

	public void setNationName(String nationName) {
		this.nationName = nationName;
	}

	public String getPoliticsStatus() {
		return politicsStatus;
	}

	public void setPoliticsStatus(String politicsStatus) {
		this.politicsStatus = politicsStatus;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getProfessional() {
		return professional;
	}

	public void setProfessional(String professional) {
		this.professional = professional;
	}

	public String getGraduationDate() {
		return graduationDate;
	}

	public void setGraduationDate(String graduationDate) {
		this.graduationDate = graduationDate;
	}

	public String getWorkDate() {
		return workDate;
	}

	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public Integer getIsDisable() {
		return isDisable;
	}

	public void setIsDisable(Integer isDisable) {
		this.isDisable = isDisable;
	}

	public Long getCanceledTimestamp() {
		return canceledTimestamp;
	}

	public void setCanceledTimestamp(Long canceledTimestamp) {
		this.canceledTimestamp = canceledTimestamp;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getOnlineTimestamp() {
		return onlineTimestamp;
	}

	public void setOnlineTimestamp(Long onlineTimestamp) {
		this.onlineTimestamp = onlineTimestamp;
	}
}
