/*
 * Copyright (c) 2008 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package vavi.apps.umjammer00;

import vavi.net.rest.Formatted;
import vavi.net.rest.Formatter;
import vavi.net.rest.Parameter;
import vavi.net.rest.Rest;


/**
 * YahooJapanParse. 
 *
 * @author <a href="mailto:vavivavi@yahoo.co.jp">Naohide Sano</a> (nsano)
 * @version 0.00 080319 nsano initial version <br>
 * @see "http://developer.yahoo.co.jp/jlp/MAService/V1/parse.html"
 */
@Rest(protocol = "HTTP",
      method="GET",
      url="http://api.jlp.yahoo.co.jp/MAService/V1/parse")
public class YahooJapanParse {

    /** �A�v���P�[�V����ID�B */ 
    @Parameter(required = true)
    String appid;

    /** ��͑Ώۂ̃e�L�X�g�ł��B */ 
    @Parameter(required = true)
    String sentence;

    /** */
    enum Result {
        /** �`�ԑf��͂̌��ʂ� ma_result �ɕԂ��܂��B */
        ma,
        /** �o���p�x���� uniq_result �ɕԂ��܂��B */
        uniq
    }

    /**
     * ��͌��ʂ̎�ނ��R���}�ŋ�؂��Ďw�肵�܂��B   
     * "ma": �`�ԑf��͂̌��ʂ� ma_result �ɕԂ��܂��B
     * "uniq": �o���p�x���� uniq_result �ɕԂ��܂��B
     * ���w��̏ꍇ�� "ma" �ɂȂ�܂��B
     */
    @Parameter(required = true)
    String results = "ma";

    /** */
    public enum Response {
        surface,
        reading,
        pos,
        baseform,
        feature,
        ma_response,
        uniq_response
    }
     
    /**
     * surface, reading, pos, baseform, feature ma_response, uniq_response �̃f�t�H���g�ݒ�ł��B
     * word �ɕԂ����`�ԑf�����R���}�ŋ�؂��Ďw�肵�܂��B 
     * ���w��̏ꍇ�� "surface,reading,pos" �ɂȂ�܂��B
     */ 
    @Parameter
    @Formatted(formatter = ResponseFormatter.class)
    String response;

    /** */
    public enum Filter {
        �`�e��, 
        �`�e����,
        ������,
        ���� ,
        �A�̎� ,
        �ڑ��� ,
        �ړ��� ,
        �ڔ��� ,
        ���� ,
        ���� ,
        ���� ,
        ������ ,
        // (��Ǔ_�A�J�b�R�A�L���Ȃ�)
        ����
    }

    /**
     * ma_filter, uniq_filter �̃f�t�H���g�ݒ�ł��B 
     * ��͌��ʂƂ��ďo�͂���i���ԍ��� "�b" �ŋ�؂��Ďw�肵�܂��B
     * <pre>
     * filter�Ɏw��\�ȕi���ԍ�: 
     *   1 : �`�e�� 
     *   2 : �`�e���� 
     *   3 : ������ 
     *   4 : ���� 
     *   5 : �A�̎� 
     *   6 : �ڑ��� 
     *   7 : �ړ��� 
     *   8 : �ڔ��� 
     *   9 : ���� 
     *  10 : ���� 
     *  11 : ���� 
     *  12 : ������ 
     *  13 : ����i��Ǔ_�A�J�b�R�A�L���Ȃǁj
     * </pre>
     */
    @Parameter
    @Formatted(formatter = FilterFormatter.class)
    Filter[] filter;

    /**
     * ma_result ���� word �ɕԂ����`�ԑf�����R���}�ŋ�؂��Ďw�肵�܂��B
     * ���w��̏ꍇ response �̎w�肪�p�����܂��B
     */ 
    @Parameter
    @Formatted(formatter = ResponseFormatter.class)
    Response[] ma_response;

    /**
     * ma_result ���ɉ�͌��ʂƂ��ďo�͂���i���ԍ��� "�b" �ŋ�؂��Ďw�肵�܂��B
     * ���w��̏ꍇ filter �̎w�肪�p�����܂��B
     */ 
    @Parameter
    @Formatted(formatter = FilterFormatter.class)
    Filter[] ma_filter;

    /**
     * uniq_result ���� word �ɕԂ����`�ԑf�����R���}�ŋ�؂��Ďw�肵�܂��B
     * ���w��̏ꍇ response �̎w�肪�p�����܂��B
     */
    @Parameter
    @Formatted(formatter = ResponseFormatter.class)
    Response[] uniq_response;

    /**
     * uniq_result ���ɉ�͌��ʂƂ��ďo�͂���i���ԍ��� "�b" �ŋ�؂��Ďw�肵�܂��B
     * ���w��̏ꍇ filter �̎w�肪�p�����܂��B
     */ 
    @Parameter
    @Formatted(formatter = FilterFormatter.class)
    Filter[] uniq_filter;

    /**
     * ���̃p�����[�^�� true �Ȃ�΁A��{�`�̓��ꐫ�ɂ��A
     * uniq_result �̌��ʂ����߂܂��B
     */ 
    @Parameter
    Boolean uniq_by_baseform;

    /** */
    public static class ResultFormatter implements Formatter {
        @Override
        public String format(String format, Object value) {
            Result[] results = (Result[]) value;
            StringBuilder sb = new StringBuilder();
            for (Result result : results) {
                sb.append(result.name());
                sb.append(',');
            }
            sb.setLength(sb.length() - 1);
            return sb.toString();
        }
    }

    /** */
    public static class ResponseFormatter implements Formatter {
        @Override
        public String format(String format, Object value) {
            Response[] responses = (Response[]) value;
            StringBuilder sb = new StringBuilder();
            for (Response response : responses) {
                sb.append(response.name());
                sb.append(',');
            }
            sb.setLength(sb.length() - 1);
            return sb.toString();
        }
    }

    /** */
    public static class FilterFormatter implements Formatter {
        @Override
        public String format(String format, Object value) {
            Filter[] filters = (Filter[]) value;
            StringBuilder sb = new StringBuilder();
            for (Filter filter : filters) {
                sb.append(filter.ordinal() + 1);
                sb.append('|');
            }
            sb.setLength(sb.length() - 1);
            return sb.toString();
        }
    }
}

/* */
