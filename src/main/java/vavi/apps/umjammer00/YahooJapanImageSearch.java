/*
 * Copyright (c) 2008 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package vavi.apps.umjammer00;

import java.util.List;

import vavi.net.rest.EnumType;
import vavi.net.rest.Enumerated;
import vavi.net.rest.Parameter;
import vavi.net.rest.Rest;


/**
 * YahooJapanImageSearch. 
 *
 * @author <a href="mailto:vavivavi@yahoo.co.jp">Naohide Sano</a> (nsano)
 * @version 0.00 080319 nsano initial version <br>
 * @see "http://developer.yahoo.co.jp/search/web/V1/webSearch.html"
 */
@Rest(protocol = "HTTP",
      method="GET",
      url="http://api.search.yahoo.co.jp/ImageSearchService/V1/imageSearch")
public class YahooJapanImageSearch {

    /** �A�v���P�[�V����ID�B */ 
    @Parameter(required = true)
    String appid;

    /**
     * (UTF-8�G���R�[�h���ꂽ) �����N�G���[�ł��B
     * �������܂ޏꍇ�� '+'�A�܂܂Ȃ��ꍇ�� '-' ���w�肵�܂��B
     * �t���[�Y�̏ꍇ�� "���� �N�G���[" �̂悤�� " �ł�����܂��B
     */ 
    @Parameter(required = true)
    String query;

    enum Type {
        /** (�f�t�H���g) �S�N�G���[�������܂ތ������ʂ�Ԃ��܂��B */ 
        all,
        /** �N�G���[�����̂��������ꂩ���܂ތ������ʂ�Ԃ��܂��B */ 
        any,
        /** �N�G���[�����𕶏͂Ƃ��Ċ܂ތ������ʂ�Ԃ��܂��B */ 
        phrase
    }

    @Parameter
    @Enumerated(value = EnumType.STRING)
    Type type;

    /** 10 (�f�t�H���g), 50 (�ő�) �ԋp���ʂ̐��ł��B */ 
    @Parameter
    Integer results;

    /**
     * 1 (�f�t�H���g)
     * �ԋp���ʂ̐擪�ʒu�ł��B
     * �ŏI�ʒu (start + results - 1) �́A1000�𒴂����܂���B
     */
    @Parameter
    Integer start;

    enum Format {
        /** �i�f�t�H���g�j*/
        any,
        bmp,
        gif,
        jpeg,
        png
    }

    /** ��������摜�̎�ނ��w�肵�܂��B */
    @Parameter
    @Enumerated(value = EnumType.STRING)
    Format format;

    /**
     * �l�Ȃ� (�f�t�H���g)
     * 1 �A�_���g�R���e���c�̌������ʂ��܂߂邩�ǂ������w�肵�܂��B
     * 1 �̏ꍇ�̓A�_���g�R���e���c���܂݂܂��B
     * TODO �l������ annotation
     */ 
    @Parameter
    Integer adult_ok;

    enum Coloration {
        /** �i�f�t�H���g�j*/
        any,
        color,
        bw
    }

    /** ��������摜�̎�ނ��w�肵�܂��B */
    @Parameter
    @Enumerated(value = EnumType.STRING)
    Format coloration;

    /**
     * �l�Ȃ� (�f�t�H���g) 
     * ��������h���C���i�Ⴆ�� www.yahoo.co.jp�j�𐧌����܂��B
     * 30�h���C���܂Ŏw�肷�邱�Ƃ��ł��܂��B
     * (site=www.yahoo.co.jp&site=www.asahi.com)
     */
    @Parameter
    List<String> site;
}

/* */
