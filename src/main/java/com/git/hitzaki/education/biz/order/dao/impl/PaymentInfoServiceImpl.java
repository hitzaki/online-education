package com.git.hitzaki.education.biz.order.dao.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.git.hitzaki.education.biz.order.entity.PaymentInfoEntity;
import com.git.hitzaki.education.biz.order.mapper.PaymentInfoMapper;
import com.git.hitzaki.education.biz.order.dao.IPaymentInfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 支付信息表 服务实现类
 * </p>
 *
 * @author author
 * @since 2025-01-26
 */
@Service
public class PaymentInfoServiceImpl extends ServiceImpl<PaymentInfoMapper, PaymentInfoEntity> implements IPaymentInfoService {

}
