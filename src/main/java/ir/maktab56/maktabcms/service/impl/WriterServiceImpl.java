package ir.maktab56.maktabcms.service.impl;

import ir.maktab56.maktabcms.base.service.impl.BaseEntityServiceImpl;
import ir.maktab56.maktabcms.domain.Writer;
import ir.maktab56.maktabcms.repository.WriterRepository;
import ir.maktab56.maktabcms.service.WriterService;

public class WriterServiceImpl extends BaseEntityServiceImpl<Writer, Long, WriterRepository> implements WriterService {

    public WriterServiceImpl(WriterRepository repository) {
        super(repository);
    }
}
