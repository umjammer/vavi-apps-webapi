/*
 * Copyright (c) 2008 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package vavi.apps.umjammer00;

import vavi.net.rest.EnumType;
import vavi.net.rest.Enumerated;
import vavi.net.rest.Parameter;
import vavi.net.rest.Rest;


/**
 * YahooJapanSearch. 
 *
 * @author <a href="mailto:vavivavi@yahoo.co.jp">Naohide Sano</a> (nsano)
 * @version 0.00 080319 nsano initial version <br>
 * @see "http://developer.yahoo.co.jp/search/web/V1/webSearch.html"
 */
@Rest(protocol = "HTTP",
      method="GET",
      url="http://api.search.yahoo.co.jp/WebSearchService/V1/webSearch")
public class YahooJapanSearch {

    /** �A�v���P�[�V����ID�B */ 
    @Parameter(required = true)
    String appid;

    /**
     * (UTF-8�G���R�[�h���ꂽ) �����N�G���[�ł��B
     * ���̃N�G���[��Yahoo!�����̑S������T�|�[�g���A
     * �܂����^�L�[���[�h���܂݂܂��B
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

    /** 10�i�f�t�H���g�j, 50�i�ő�j �ԋp���ʂ̐��ł��B */ 
    @Parameter
    Integer results;

    /**
     * 1�i�f�t�H���g�j
     * �ԋp���ʂ̐擪�ʒu�ł��B
     * �ŏI�ʒu�istart + results - 1�j�́A1000�𒴂����܂���B
     */
    @Parameter
    Integer start;

    enum Format {
        /** �i�f�t�H���g�j*/
        any,
        html,
        msword,
        pdf,
        ppt,
        rss,
        txt,
        xls
    }

    /**  ��������t�@�C���̎�ނ��w�肵�܂��B */
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

    /**
     * �l�Ȃ� (�f�t�H���g)
     * 1 �����R���e���c��ʂ̌������ʂƂ��邩�ǂ������w�肵�܂��B
     * 1 �̏ꍇ�͓����R���e���c���܂݂܂��B
     */ 
    @Parameter
    Integer similar_ok;

    /**
     * ja (�f�t�H���g) language�ŏ����ꂽ���ʂɂȂ�܂��B
     * �u�T�|�[�g���Ă��錾��v�����Q�Ƃ��������B
     */ 
    @Parameter
    String language;

    /**
     * �l�Ȃ� (�f�t�H���g)
     * �E�F�u�T�C�g���ʒu���鍑�̍��R�[�h�ł��B
     * �u�T�|�[�g���Ă��鍑�E�n��v�����Q�Ƃ��������B
     */ 
    @Parameter
    String country;

    /**
     * �l�Ȃ� (�f�t�H���g) 
     * ��������h���C���i�Ⴆ�� www.yahoo.co.jp�j�𐧌����܂��B
     * 30�h���C���܂Ŏw�肷�邱�Ƃ��ł��܂��B
     * (site=www.yahoo.co.jp&site=www.asahi.com)
     */
    @Parameter
    String site;
}

/* */
