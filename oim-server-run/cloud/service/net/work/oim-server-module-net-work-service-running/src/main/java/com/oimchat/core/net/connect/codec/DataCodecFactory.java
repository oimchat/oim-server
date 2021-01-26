package com.oimchat.core.net.connect.codec;

import java.nio.charset.Charset;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

/**
 * 
 * Description <br>
 * Date 2021-01-13 16:39:48<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
public class DataCodecFactory implements ProtocolCodecFactory {

	private DataCodecEncoder encoder;
	private DataCodecDecoder decoder;

	public DataCodecFactory() {
		this(Charset.forName("UTF-8"));
	}

	public DataCodecFactory(Charset charset) {
		encoder = new DataCodecEncoder(charset);
		decoder = new DataCodecDecoder(charset);
	}

	@Override
	public ProtocolEncoder getEncoder(IoSession session) {
		return encoder;
	}

	@Override
	public ProtocolDecoder getDecoder(IoSession session) {
		return decoder;
	}
}
