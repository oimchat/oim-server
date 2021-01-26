package com.oimchat.server.general.kernel.work.module.base.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.onlyxiahui.aware.basic.bean.PrimaryStringEntity;
import com.onlyxiahui.extend.hibernate.annotation.Comment;

/**
 * 用户信息<br>
 * Date 2019-01-17 23:41:00<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Entity
@Table(name = "im_user", indexes = {
		@Index(name = "index_number", columnList = "number", unique = true),
		@Index(name = "index_account", columnList = "account", unique = true),
		@Index(name = "index_email", columnList = "email", unique = false),
		@Index(name = "index_mobile", columnList = "mobile", unique = false),
		@Index(name = "index_nickname", columnList = "nickname", unique = false),
		@Index(name = "index_name", columnList = "name", unique = false),
		// @Index(name = "ix_spell", columnList = "spell", unique = false),
		@Index(name = "index_simpleSpell", columnList = "simpleSpell", unique = false)
})
@DynamicInsert
@DynamicUpdate
public class User extends PrimaryStringEntity {

	/**
	 * 数字帐号
	 */
	@Comment("用户数字账号")
	@ColumnDefault("0")
	@Column(nullable = false, updatable = false)
	private Long number;

	/**
	 * 帐号
	 */
	@Comment("帐号")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String account;

	/**
	 * 电子邮箱
	 */
	@Comment("电子邮箱")
	@ColumnDefault("''")
	@Column(nullable = false, length = 150)
	private String email;

	/**
	 * 手机号码
	 */
	@Comment("手机号码")
	@ColumnDefault("''")
	@Column(nullable = false, length = 30)
	private String mobile;

	/**
	 * 密码
	 */
	@Comment("密码")
	@ColumnDefault("''")
	@Column(nullable = false, length = 250)
	private String password;

	/********************************************************************************
	 * 基本信息 *
	 ******************************************************************************/

	/**
	 * 系统头像编号
	 */
	@Comment("系统头像编号")
	@ColumnDefault("'1'")
	@Column(nullable = false, length = 4)
	private String head;

	/**
	 * 自定义照片，（当用户选择系统头像时为空）
	 */
	@Comment("自定义照片，（当用户选择系统头像时为空）")
	@ColumnDefault("''")
	@Column(nullable = false, length = 500)
	private String avatar;

	/**
	 * 昵称
	 */
	@Comment("昵称")
	@ColumnDefault("''")
	@Column(nullable = false, length = 100)
	private String nickname;

	/**
	 * 真实姓名
	 */
	@Comment("真实姓名")
	@ColumnDefault("''")
	@Column(nullable = false, length = 200)
	private String name;

	/**
	 * 姓名的拼写
	 */
	@Comment("姓名的拼写")
	@ColumnDefault("''")
	@Column(nullable = false, length = 1000)
	private String spell;

	/**
	 * 姓名的简拼
	 */
	@Comment("姓名的简拼")
	@ColumnDefault("''")
	@Column(nullable = false, length = 200)
	private String simpleSpell;

	/**
	 * 性别 1:男 2：女 3：保密
	 */
	@Comment("性别 1:男 2：女 3：保密")
	@ColumnDefault("'3'")
	@Column(nullable = false, length = 2)
	private String gender;

	/**
	 * 联系电话（固定电话）
	 */
	@Comment("联系电话（固定电话）")
	@ColumnDefault("''")
	@Column(nullable = false, length = 50)
	private String telephone;

	/**
	 * 家庭地址
	 */
	@Comment("家庭地址")
	@ColumnDefault("''")
	@Column(nullable = false, length = 500)
	private String homeAddress;

	/**
	 * 所在地址
	 */
	@Comment("所在地址")
	@ColumnDefault("''")
	@Column(nullable = false, length = 500)
	private String locationAddress;

	/**
	 * 家庭地邮政编码
	 */
	@Comment("家庭地邮政编码")
	@ColumnDefault("''")
	@Column(nullable = false, length = 100)
	private String homeZipCode;

	/**
	 * 所在地邮政编码
	 */
	@Comment("所在地邮政编码")
	@ColumnDefault("''")
	@Column(nullable = false, length = 100)
	private String locationZipCode;

	/**
	 * 星座
	 */
	@Comment("星座")
	@Column(nullable = false, length = 10)
	@ColumnDefault("''")
	private String constellationCode;

	/**
	 * 血型
	 */
	@Comment("血型")
	@ColumnDefault("''")
	@Column(nullable = false, length = 5)
	private String blood;

	/**
	 * 出生日期
	 */
	@Comment("出生日期")
	@ColumnDefault("'0001-01-01'")
	@Column(nullable = false, length = 32)
	private String birthDate;

	/**
	 * 年龄
	 */
	@Comment("年龄")
	@ColumnDefault("0")
	@Column(nullable = false, length = 4)
	private Integer age;

	/**
	 * 身份证号码
	 */
	@Comment("身份证号码")
	@ColumnDefault("''")
	@Column(nullable = false, length = 30)
	private String identityCard;

	/**
	 * 婚姻状况: 1:未婚 2:已婚
	 */
	@Comment("婚姻状况: 1:未婚 2:已婚")
	@ColumnDefault("''")
	@Column(nullable = false, length = 5)
	private String maritalStatus;

	/**
	 * 籍贯
	 */
	@Comment("籍贯")
	@ColumnDefault("''")
	@Column(nullable = false, length = 200)
	private String nativePlace;

	/**
	 * 民族
	 */
	@Comment("民族")
	@Column(nullable = false, length = 40)
	@ColumnDefault("''")
	private String nationName;

	/**
	 * 政治面貌
	 */
	@Comment("政治面貌")
	@ColumnDefault("''")
	@Column(nullable = false, length = 20)
	private String politicsStatus;

	/**
	 * 介绍
	 */
	@Comment("介绍")
	@ColumnDefault("''")
	@Column(nullable = false, length = 1500)
	private String introduce;

	/**
	 * 备注
	 */
	@Comment("备注")
	@ColumnDefault("''")
	@Column(nullable = false, length = 500)
	private String remark;

	/**
	 * qq号码
	 */
	@Comment("qq号码")
	@ColumnDefault("''")
	@Column(nullable = false, length = 30)
	private String qq;

	/**
	 * 学历
	 */
	@Comment("学历")
	@ColumnDefault("''")
	@Column(nullable = false, length = 30)
	private String education;

	/**
	 * 毕业学校
	 */
	@Comment("毕业学校")
	@ColumnDefault("''")
	@Column(nullable = false, length = 100)
	private String school;

	/**
	 * 专业
	 */
	@Comment("专业")
	@ColumnDefault("''")
	@Column(nullable = false, length = 100)
	private String professional;

	/**
	 * 毕业时间
	 */
	@Comment("毕业时间")
	@ColumnDefault("''")
	@Column(nullable = false, length = 20)
	private String graduationDate;

	/**
	 * 参加工作时间
	 */
	@Comment("参加工作时间")
	@ColumnDefault("''")
	@Column(nullable = false, length = 20)
	private String workDate;

	/**
	 * 个性签名
	 */
	@Comment("个性签名")
	@ColumnDefault("''")
	@Column(nullable = false, length = 200)
	private String signature;
	/**
	 * 是否禁用 0：启用 1：停用
	 */
	@Comment("是否禁用 0：启用 1：停用")
	@ColumnDefault("0")
	@Column(nullable = false)
	private Integer isDisable;
	/**
	 * 注销时间
	 */
	@Comment("注销时间")
	@ColumnDefault("0")
	@Column(nullable = false, length = 32)
	private Long canceledTimestamp;
	/**
	 * 用户类型 0:普通用户 1：管理员用户 2:超级管理员
	 */
	@Comment("用户类型 0:普通用户 1：管理员用户 2:超级管理员")
	@ColumnDefault("'0'")
	@Column(nullable = false, length = 2)
	private String type;

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

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
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
}
