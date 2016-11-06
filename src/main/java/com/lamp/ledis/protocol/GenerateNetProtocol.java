/*package com.lamp.ledis.protocol;

import java.io.IOException;

import redis.clients.jedis.exceptions.JedisConnectionException;
import redis.clients.util.RedisOutputStream;

public class GenerateNetProtocol {
	protected final byte[] buf;

	protected int count;

	private final static int[] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999,
			Integer.MAX_VALUE };

	private final static byte[] DigitTens = { '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1',
			'1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3',
			'3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5',
			'5', '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7',
			'7', '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9',
			'9', };

	private final static byte[] DigitOnes = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4',
			'5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6',
			'7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7',
			'8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8',
			'9', };

	private final static byte[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
			'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
	
	

	public void writeIntCrLf(int value) throws IOException {
		if (value < 0) {
			write((byte) '-');
			value = -value;
		}

		int size = 0;
		while (value > sizeTable[size])
			size++;

		size++;
		if (size >= buf.length - count) {
			flushBuffer();
		}

		int q, r;
		int charPos = count + size;

		while (value >= 65536) {
			q = value / 100;
			r = value - ((q << 6) + (q << 5) + (q << 2));
			value = q;
			buf[--charPos] = DigitOnes[r];
			buf[--charPos] = DigitTens[r];
		}

		for (;;) {
			q = (value * 52429) >>> (16 + 3);
			r = value - ((q << 3) + (q << 1));
			buf[--charPos] = digits[r];
			value = q;
			if (value == 0)
				break;
		}
		count += size;

		writeCrLf();
	}

	public void flush() throws IOException {
		flushBuffer();
		out.flush();
	}

	public void writeCrLf() throws IOException {
		if (2 >= buf.length - count) {
			flushBuffer();
		}

		buf[count++] = '\r';
		buf[count++] = '\n';
	}

	private void flushBuffer() throws IOException {
		if (count > 0) {
			out.write(buf, 0, count);
			count = 0;
		}
	}
	
	private static void sendCommand(final RedisOutputStream os, final byte[] command,
		      final byte[]... args) {
		    try {
		      os.write(ASTERISK_BYTE);
		      os.writeIntCrLf(args.length + 1);
		      os.write(DOLLAR_BYTE);
		      os.writeIntCrLf(command.length);
		      os.write(command);
		      os.writeCrLf();

		      for (final byte[] arg : args) {
		        os.write(DOLLAR_BYTE);
		        os.writeIntCrLf(arg.length);
		        os.write(arg);
		        os.writeCrLf();
		      }
		    } catch (IOException e) {
		      throw new JedisConnectionException(e);
		    }
		  }
	
}
*/