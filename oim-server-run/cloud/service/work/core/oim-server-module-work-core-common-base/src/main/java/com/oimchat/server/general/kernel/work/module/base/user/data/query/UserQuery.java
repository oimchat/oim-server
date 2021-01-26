package com.oimchat.server.general.kernel.work.module.base.user.data.query;

import java.util.Date;
import java.util.List;

import com.onlyxiahui.extend.query.hibernate.syntax.annotation.Bracket;
import com.onlyxiahui.extend.query.hibernate.syntax.annotation.Condition;
import com.onlyxiahui.extend.query.hibernate.syntax.annotation.Like;
import com.onlyxiahui.extend.query.hibernate.syntax.annotation.OrderBy;

/**
 * 
 * <br>
 * Date <br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]
 * @since 1.0.0
 */
@OrderBy(value = { "updatedTimestamp" }, sort = "desc")
public class UserQuery {

	@Condition(equation = "in", column = "id")
	private List<String> ids;

	/**
	 * 
	 */
	private String id;

	/**
	 * 
	 */
	private Integer isDeleted;

	/**
	 * 
	 */
	private String account;

	/**
	 * 
	 */
	private Integer age;

	/**
	 * 
	 */
	private Date birthDate;

	/**
	 * 
	 */
	private String blood;

	/**
	 * 
	 */
	private String constellationCode;

	/**
	 * 
	 */
	private String email;

	/**
	 * 
	 */
	private String gender;

	/**
	 * 
	 */
	private String head;

	/**
	 * 
	 */
	private String homeZipCode;

	/**
	 * 
	 */
	private String identityCard;

	/**
	 * 
	 */
	private Integer isDisable;

	/**
	 * 
	 */
	private String locationZipCode;

	/**
	 * 
	 */
	private String maritalStatus;

	/**
	 * 
	 */
	private String mobile;

	/**
	 * 
	 */
	private String name;

	/**
	 * 
	 */
	private String nationName;

	/**
	 * 
	 */
	private String nativePlace;

	/**
	 * 
	 */
	private String nickname;

	/**
	 * 
	 */
	private Long number;

	/**
	 * 
	 */
	private String password;

	/**
	 * 
	 */
	private String politicsStatus;

	/**
	 * 
	 */
	private String professional;

	/**
	 * 
	 */
	private String simpleSpell;

	/**
	 * 
	 */
	private String spell;

	/**
	 * 
	 */
	private String telephone;

	/**
	 * 
	 */
	private String type;

	@Bracket()
	@Condition(column = "name", bind = "or")
	@Condition(column = "nickname", bind = "or")
	@Condition(column = "email", bind = "or")
	@Condition(column = "account", bind = "or")
	@Condition(column = "number", bind = "or")
	@Like
	private String queryText;

	public List<String> getIds() {
		return ids;
	}

	public void setIds(List<String> ids) {
		this.ids = ids;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getBlood() {
		return blood;
	}

	public void setBlood(String blood) {
		this.blood = blood;
	}

	public String getConstellationCode() {
		return constellationCode;
	}

	public void setConstellationCode(String constellationCode) {
		this.constellationCode = constellationCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getHomeZipCode() {
		return homeZipCode;
	}

	public void setHomeZipCode(String homeZipCode) {
		this.homeZipCode = homeZipCode;
	}

	public String getIdentityCard() {
		return identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	public Integer getIsDisable() {
		return isDisable;
	}

	public void setIsDisable(Integer isDisable) {
		this.isDisable = isDisable;
	}

	public String getLocationZipCode() {
		return locationZipCode;
	}

	public void setLocationZipCode(String locationZipCode) {
		this.locationZipCode = locationZipCode;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNationName() {
		return nationName;
	}

	public void setNationName(String nationName) {
		this.nationName = nationName;
	}

	public String getNativePlace() {
		return nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPoliticsStatus() {
		return politicsStatus;
	}

	public void setPoliticsStatus(String politicsStatus) {
		this.politicsStatus = politicsStatus;
	}

	public String getProfessional() {
		return professional;
	}

	public void setProfessional(String professional) {
		this.professional = professional;
	}

	public String getSimpleSpell() {
		return simpleSpell;
	}

	public void setSimpleSpell(String simpleSpell) {
		this.simpleSpell = simpleSpell;
	}

	public String getSpell() {
		return spell;
	}

	public void setSpell(String spell) {
		this.spell = spell;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getQueryText() {
		return queryText;
	}

	public void setQueryText(String queryText) {
		this.queryText = queryText;
	}
}