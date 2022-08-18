package com.example.mpdemo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mpdemo.modules.businessa.domain.Employees;
import com.example.mpdemo.modules.businessa.mapper.EmployeesMapper;
import com.example.mpdemo.modules.businessa.service.EmployeesService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

//@SpringBootTest
//@Rollback(value = false)
class MpdemoApplicationTests {

    @Autowired
    EmployeesMapper employeesMapper;
    @Autowired
    EmployeesService employeesService;

    @Test
    void baseMapperQuery() {
        System.out.println(("----- selectAll method test ------"));
        List<Employees> userList = employeesMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    void customAnnotationQuery() {
        System.out.println(("----- Annotation method test ------"));
        List<Employees> userList = employeesMapper.selectByAnnotation("Lim%");
        userList.forEach(System.out::println);
    }
    @Test
    void customXmlQuery() {
        System.out.println(("----- XmlQuery method test ------"));
        List<Employees> userList = employeesMapper.selectByXml("Lim%");
        userList.forEach(System.out::println);
    }

    @Test
    void pagehelpr() {
        System.out.println(("----- pagehelper method test ------"));
        long count = PageHelper.startPage(1, 2).doCount(() -> employeesMapper.selectList(null));
        System.out.println(count);
    }

    @Test
    void pagehelprXml() {
        System.out.println(("----- pagehelperXml method test ------"));
        Page<Object> page = PageHelper.startPage(1, 2).doSelectPage(() -> employeesMapper.selectByXml("Lim%"));
        System.out.println(page);
    }

    @Test
    void TransactionTest() {
        System.out.println(("----- Transactional method test ------"));
        QueryWrapper<Employees> wrapper = new QueryWrapper<>();
        wrapper.likeRight("first_name", "Ji");
        employeesService.remove(wrapper);
    }

    @Test
    void QrCodeTest() throws WriterException {
        System.out.println(("----- QrCode method test ------"));
        String myCodeText = "Hello !!!@@@";
        int size = 512;
        Map<EncodeHintType, Object> crunchifyHintType = new EnumMap<>(EncodeHintType.class);
        crunchifyHintType.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        // Now with version 3.4.1 you could change margin (white border size)
        crunchifyHintType.put(EncodeHintType.MARGIN, 1); /* default = 4 */
        Object put = crunchifyHintType.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        QRCodeWriter mYQRCodeWriter = new QRCodeWriter(); // throws com.google.zxing.WriterException
        BitMatrix crunchifyBitMatrix = mYQRCodeWriter.encode(myCodeText, BarcodeFormat.QR_CODE, 0,
                0, crunchifyHintType);
        //\u2588完整方块
        final char FULL_BLACK_CHAR= '█';
        //\u2580上半方块
        final char TOP_BLACK_CHAR= '▀';
        //\u2584下半方块
        final char BOTTOM_BLACK_CHAR= '▄';
        int width = crunchifyBitMatrix.getWidth();
        int height = crunchifyBitMatrix.getHeight();
        StringBuilder result = new StringBuilder(height * (width + 1));
        for (int i = 0; i <= height; i+=2) {
            for (int j = 0; j < width; j++) {
                boolean tp = crunchifyBitMatrix.get(i, j);
                boolean bt = i + 1 <= height && crunchifyBitMatrix.get(i + 1, j);
                if(tp &&bt){
                    result.append(' ');
                } else if (tp) {
                    result.append(BOTTOM_BLACK_CHAR);
                } else if (bt) {
                    result.append(TOP_BLACK_CHAR);
                } else {
                    result.append(FULL_BLACK_CHAR);
                }

            }
            result.append('\n');
        }
        System.out.println(result);
    }

}
