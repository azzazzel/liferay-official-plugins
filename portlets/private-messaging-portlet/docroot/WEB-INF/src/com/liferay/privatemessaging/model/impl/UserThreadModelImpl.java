/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.privatemessaging.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.liferay.privatemessaging.model.UserThread;
import com.liferay.privatemessaging.model.UserThreadModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the UserThread service. Represents a row in the &quot;PM_UserThread&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.privatemessaging.model.UserThreadModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link UserThreadImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserThreadImpl
 * @see com.liferay.privatemessaging.model.UserThread
 * @see com.liferay.privatemessaging.model.UserThreadModel
 * @generated
 */
public class UserThreadModelImpl extends BaseModelImpl<UserThread>
	implements UserThreadModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a user thread model instance should use the {@link com.liferay.privatemessaging.model.UserThread} interface instead.
	 */
	public static final String TABLE_NAME = "PM_UserThread";
	public static final Object[][] TABLE_COLUMNS = {
			{ "userThreadId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "mbThreadId", Types.BIGINT },
			{ "topMBMessageId", Types.BIGINT },
			{ "read_", Types.BOOLEAN },
			{ "deleted", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table PM_UserThread (userThreadId LONG not null primary key,companyId LONG,userId LONG,createDate DATE null,modifiedDate DATE null,mbThreadId LONG,topMBMessageId LONG,read_ BOOLEAN,deleted BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table PM_UserThread";
	public static final String ORDER_BY_JPQL = " ORDER BY userThread.modifiedDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY PM_UserThread.modifiedDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.privatemessaging.model.UserThread"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.privatemessaging.model.UserThread"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.privatemessaging.model.UserThread"),
			true);
	public static long DELETED_COLUMN_BITMASK = 1L;
	public static long MBTHREADID_COLUMN_BITMASK = 2L;
	public static long READ_COLUMN_BITMASK = 4L;
	public static long USERID_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.privatemessaging.model.UserThread"));

	public UserThreadModelImpl() {
	}

	public long getPrimaryKey() {
		return _userThreadId;
	}

	public void setPrimaryKey(long primaryKey) {
		setUserThreadId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_userThreadId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return UserThread.class;
	}

	public String getModelClassName() {
		return UserThread.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userThreadId", getUserThreadId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("mbThreadId", getMbThreadId());
		attributes.put("topMBMessageId", getTopMBMessageId());
		attributes.put("read", getRead());
		attributes.put("deleted", getDeleted());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userThreadId = (Long)attributes.get("userThreadId");

		if (userThreadId != null) {
			setUserThreadId(userThreadId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long mbThreadId = (Long)attributes.get("mbThreadId");

		if (mbThreadId != null) {
			setMbThreadId(mbThreadId);
		}

		Long topMBMessageId = (Long)attributes.get("topMBMessageId");

		if (topMBMessageId != null) {
			setTopMBMessageId(topMBMessageId);
		}

		Boolean read = (Boolean)attributes.get("read");

		if (read != null) {
			setRead(read);
		}

		Boolean deleted = (Boolean)attributes.get("deleted");

		if (deleted != null) {
			setDeleted(deleted);
		}
	}

	public long getUserThreadId() {
		return _userThreadId;
	}

	public void setUserThreadId(long userThreadId) {
		_userThreadId = userThreadId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_columnBitmask = -1L;

		_modifiedDate = modifiedDate;
	}

	public long getMbThreadId() {
		return _mbThreadId;
	}

	public void setMbThreadId(long mbThreadId) {
		_columnBitmask |= MBTHREADID_COLUMN_BITMASK;

		if (!_setOriginalMbThreadId) {
			_setOriginalMbThreadId = true;

			_originalMbThreadId = _mbThreadId;
		}

		_mbThreadId = mbThreadId;
	}

	public long getOriginalMbThreadId() {
		return _originalMbThreadId;
	}

	public long getTopMBMessageId() {
		return _topMBMessageId;
	}

	public void setTopMBMessageId(long topMBMessageId) {
		_topMBMessageId = topMBMessageId;
	}

	public boolean getRead() {
		return _read;
	}

	public boolean isRead() {
		return _read;
	}

	public void setRead(boolean read) {
		_columnBitmask |= READ_COLUMN_BITMASK;

		if (!_setOriginalRead) {
			_setOriginalRead = true;

			_originalRead = _read;
		}

		_read = read;
	}

	public boolean getOriginalRead() {
		return _originalRead;
	}

	public boolean getDeleted() {
		return _deleted;
	}

	public boolean isDeleted() {
		return _deleted;
	}

	public void setDeleted(boolean deleted) {
		_columnBitmask |= DELETED_COLUMN_BITMASK;

		if (!_setOriginalDeleted) {
			_setOriginalDeleted = true;

			_originalDeleted = _deleted;
		}

		_deleted = deleted;
	}

	public boolean getOriginalDeleted() {
		return _originalDeleted;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public UserThread toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (UserThread)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			UserThread.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		UserThreadImpl userThreadImpl = new UserThreadImpl();

		userThreadImpl.setUserThreadId(getUserThreadId());
		userThreadImpl.setCompanyId(getCompanyId());
		userThreadImpl.setUserId(getUserId());
		userThreadImpl.setCreateDate(getCreateDate());
		userThreadImpl.setModifiedDate(getModifiedDate());
		userThreadImpl.setMbThreadId(getMbThreadId());
		userThreadImpl.setTopMBMessageId(getTopMBMessageId());
		userThreadImpl.setRead(getRead());
		userThreadImpl.setDeleted(getDeleted());

		userThreadImpl.resetOriginalValues();

		return userThreadImpl;
	}

	public int compareTo(UserThread userThread) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedDate(),
				userThread.getModifiedDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		UserThread userThread = null;

		try {
			userThread = (UserThread)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = userThread.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		UserThreadModelImpl userThreadModelImpl = this;

		userThreadModelImpl._originalUserId = userThreadModelImpl._userId;

		userThreadModelImpl._setOriginalUserId = false;

		userThreadModelImpl._originalMbThreadId = userThreadModelImpl._mbThreadId;

		userThreadModelImpl._setOriginalMbThreadId = false;

		userThreadModelImpl._originalRead = userThreadModelImpl._read;

		userThreadModelImpl._setOriginalRead = false;

		userThreadModelImpl._originalDeleted = userThreadModelImpl._deleted;

		userThreadModelImpl._setOriginalDeleted = false;

		userThreadModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<UserThread> toCacheModel() {
		UserThreadCacheModel userThreadCacheModel = new UserThreadCacheModel();

		userThreadCacheModel.userThreadId = getUserThreadId();

		userThreadCacheModel.companyId = getCompanyId();

		userThreadCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			userThreadCacheModel.createDate = createDate.getTime();
		}
		else {
			userThreadCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			userThreadCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			userThreadCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		userThreadCacheModel.mbThreadId = getMbThreadId();

		userThreadCacheModel.topMBMessageId = getTopMBMessageId();

		userThreadCacheModel.read = getRead();

		userThreadCacheModel.deleted = getDeleted();

		return userThreadCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{userThreadId=");
		sb.append(getUserThreadId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", mbThreadId=");
		sb.append(getMbThreadId());
		sb.append(", topMBMessageId=");
		sb.append(getTopMBMessageId());
		sb.append(", read=");
		sb.append(getRead());
		sb.append(", deleted=");
		sb.append(getDeleted());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.liferay.privatemessaging.model.UserThread");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>userThreadId</column-name><column-value><![CDATA[");
		sb.append(getUserThreadId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mbThreadId</column-name><column-value><![CDATA[");
		sb.append(getMbThreadId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>topMBMessageId</column-name><column-value><![CDATA[");
		sb.append(getTopMBMessageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>read</column-name><column-value><![CDATA[");
		sb.append(getRead());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deleted</column-name><column-value><![CDATA[");
		sb.append(getDeleted());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = UserThread.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			UserThread.class
		};
	private long _userThreadId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _mbThreadId;
	private long _originalMbThreadId;
	private boolean _setOriginalMbThreadId;
	private long _topMBMessageId;
	private boolean _read;
	private boolean _originalRead;
	private boolean _setOriginalRead;
	private boolean _deleted;
	private boolean _originalDeleted;
	private boolean _setOriginalDeleted;
	private long _columnBitmask;
	private UserThread _escapedModelProxy;
}