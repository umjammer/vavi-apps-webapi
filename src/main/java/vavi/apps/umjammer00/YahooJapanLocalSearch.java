/*
 * Copyright (c) 2007 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package vavi.apps.umjammer00;

import vavi.net.rest.EnumType;
import vavi.net.rest.Enumerated;
import vavi.net.rest.Ignored;
import vavi.net.rest.Parameter;
import vavi.net.rest.Rest;


/**
 * Yahoo Japan WebServices LocalSearch.
 * 
 * <li> ���N�G�X�g�p�����[�^�ŁAp(�����L�[���[�h)���Alat(�ܓx)�Elon(�o�x)�Edist(����)�́A�ǂ��炩������K�{�ƂȂ�܂��B
 * <li> �ܓx�o�x�Ŏg�p�ł��鏑���͈ȉ��̂Ƃ���ł��B
 * <ul>
 * <li> �x.��.�b�`��(35.39.26.180,139.43.56.868)
 * <li> �x/��/�b�`��(35/39/26.180,139/43/56.868)
 * <li> �x�`��(35.657272,139.732463)
 * </ul>
 * 
 * @author <a href="mailto:vavivavi@yahoo.co.jp">Naohide Sano</a> (nsano)
 * @version 0.00 070224 nsano initial version <br>
 * @see "http://developer.yahoo.co.jp/map/localsearch/V1/localsearch.html"
 */
@Rest(protocol = "HTTP",
      method="GET",
      url="http://api.map.yahoo.co.jp/LocalSearchService/V1/LocalSearch")
public class YahooJapanLocalSearch {

    /**
     * �A�v���P�[�V����ID�B
     */
    @Parameter(name = "appid", required = true)
    private String token;

    /**
     * (UTF-8�G���R�[�h���ꂽ)�����L�[���[�h
     */
    @Parameter(name = "p", required = true)
    @Ignored(when = "lat != -1 && lon != -1 && dist != -1")
    private String keyword;

    /**
     * �ܓx
     * TODO �z���g�� required = true
     */
    @Parameter(required = false)
    @Ignored(when = "lat == -1")
    private int lat = -1;

    /**
     * �o�x
     * TODO �z���g�� required = true
     */
    @Parameter(required = false)
    @Ignored(when = "lon == -1")
    private int lon = -1;

    /**
     * ����(�P��km)
     * TODO �z���g�� required = true
     */
    @Parameter(required = false)
    @Ignored(when = "dist == -1")
    private float dist = -1;

    /** �����ΏۃJ�e�S�� */
    enum Category {
        /** �Z����ΏۂɌ��� */
        address,
        /** �X�֔ԍ���ΏۂɌ��� */
        zipcode,
        /** �{��(�����A�w�Z�A�a�@�A�X�֋ǂȂ�)��ΏۂɌ��� */
        landmark,
        /** �w��ΏۂɌ��� */
        station,
        /** Yahoo!�N�[�|����ΏۂɌ��� */
        courpon
    }

    /**
     * �����ΏۃJ�e�S��
     * �f�t�H���g�́Aaddress�Azipcode�Alandmark�Astation��ΏۂɌ������܂��B
     *
     * Yahoo!�N�[�|���͎��ӌ����ł̂݌����ΏۂƂȂ�܂��B
     */
    @Parameter
    @Enumerated(value = EnumType.STRING)
    private Category category;

    /**
     * �\���J�n�ʒu�B
     * 1(�f�t�H���g) 
     * �ŏI�ʒu(b + n - 1)�́A100�𒴂����܂���B
     */
    @Parameter(name = "b")
    @Ignored(when = "begin == 1")
    private int begin = 1;

    /**
     * �\������
     * 10(�f�t�H���g), 100(�ő�)
     */
    @Parameter(name = "n")
    @Ignored(when = "number == 10")
    private int number = 10;

    /** �o�̓^�C�v */
    enum OutputType {
        /** (�f�t�H���g) */
        xml,
        json
    }

    /**
     * �o�̓^�C�v
     */
    @Parameter
    @Enumerated(value = EnumType.STRING)
    private OutputType outputType;

    /** ���n�n */
    enum GeographicCoordinateSystem {
        /** ���{���n�n (�f�t�H���g) */
        tky,
        /** ���E���n�n */
        wgs
    }

    /**
     * �w�肵���ܓx�o�x�̑��n�n
     */
    @Parameter
    @Enumerated(value = EnumType.STRING)
    private GeographicCoordinateSystem datum;

    /**
     * 1, 2, 3 �Z�����x���̍i�荞��
     * 1 - �s�撬�����x��
     * 2 - ���A�厚���x��
     * 3 - ���ځA�����x��
     * �Z����ΏۂɌ��������ꍇ�̂ݗL���ł��B
     */
    @Parameter(name = "al")
    @Ignored(when = "addressLevel == -1")
    private int addressLevel = -1;

    /** */
    public String getToken() {
        return token;
    }

    /** */
    public void setToken(String token) {
        this.token = token;
    }

    /** */
    public String getKeyword() {
        return keyword;
    }

    /** */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    /** */
    public int getLat() {
        return lat;
    }

    /** */
    public void setLat(int lat) {
        this.lat = lat;
    }

    /** */
    public int getLon() {
        return lon;
    }

    /** */
    public void setLon(int lon) {
        this.lon = lon;
    }

    /** */
    public float getDist() {
        return dist;
    }

    /** */
    public void setDist(float dist) {
        this.dist = dist;
    }

    /** */
    public Category getCategory() {
        return category;
    }

    /** */
    public void setCategory(Category category) {
        this.category = category;
    }

    /** */
    public int getBegin() {
        return begin;
    }

    /** */
    public void setBegin(int begin) {
        this.begin = begin;
    }

    /** */
    public int getNumber() {
        return number;
    }

    /** */
    public void setNumber(int number) {
        this.number = number;
    }

    /** */
    public OutputType getOutputType() {
        return outputType;
    }

    /** */
    public void setOutputType(OutputType outputType) {
        this.outputType = outputType;
    }

    /** */
    public GeographicCoordinateSystem getDatum() {
        return datum;
    }

    /** */
    public void setDatum(GeographicCoordinateSystem datum) {
        this.datum = datum;
    }

    /** */
    public int getAddressLevel() {
        return addressLevel;
    }

    /** */
    public void setAddressLevel(int addressLevel) {
        this.addressLevel = addressLevel;
    }
}

/* */
