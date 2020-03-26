package com.geektcp.alpha.util.office.service;

import org.apache.commons.lang.StringUtils;
import org.krysalis.barcode4j.impl.code39.Code39Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;

import java.awt.image.BufferedImage;
import java.io.*;
/**
 * @author haiyang on 3/26/20 11:49 AM.
 */
public class BarcodeService {

    public static void main(String[] args) {
        String msg = "55555-88888-1230-0";
        String path = "barcode.png";
//        generateFile(msg, path);

        byte[] bytes = generateByte(msg);

    }


    ///////////////////////////////////////////////
    /**
     * 生成文件
     */
    public static void generateFile(String msg, String path) {
        try {
            File file = new File(path);
            generate(msg, new FileOutputStream(file));
        }catch (Exception e){
            // do something
        }

    }

    /**
     * 生成字节
     */
    public static byte[] generateByte(String msg) {
        ByteArrayOutputStream ous = new ByteArrayOutputStream();
        generate(msg, ous);
        return ous.toByteArray();
    }

    /**
     * 生成到流
     */
    private static void generate(String msg, OutputStream ous) {
        if (StringUtils.isEmpty(msg) || ous == null) {
            return;
        }
        Code39Bean bean = new Code39Bean();
        final int dpi = 150;  // 精细度
        final double moduleWidth = UnitConv.in2mm(1.0f / dpi);        // module宽度

        // 配置对象
        bean.setModuleWidth(moduleWidth);
        bean.setWideFactor(3);
        bean.doQuietZone(false);

        String format = "image/png";
        try {
            // 输出到流
            BitmapCanvasProvider canvas = new BitmapCanvasProvider(ous,
                    format,
                    dpi,
                    BufferedImage.TYPE_BYTE_BINARY,
                    false,
                    0);

            // 生成条形码
            bean.generateBarcode(canvas, msg);

            // 结束绘制
            canvas.finish();
        } catch (IOException e) {
            e.getMessage();
        }
    }


}
