package com.volkruss.tutorialstudy.caching.logic;

import com.volkruss.tutorialstudy.caching.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// @Component
public class AppRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

    @Autowired
    @Qualifier("SimpleBookRepository")
    private BookRepository simplBookRepository;

    @Autowired
    @Qualifier("TableBookRepository")
    private BookRepository tableBookRepository;


    @Override
    public void run(String... args) throws Exception {
        logger.info("BOOK取得処理開始");
        logger.info("isbn-1234--" + simplBookRepository.findByIsbn("isbn-1234"));
        logger.info("isbn-3150--" + simplBookRepository.findByIsbn("isbn-3150"));
        logger.info("isbn-3150--" + simplBookRepository.findByIsbn("isbn-3150"));
        logger.info("isbn-1234--" + simplBookRepository.findByIsbn("isbn-1234"));
        logger.info("isbn-3150--" + simplBookRepository.findByIsbn("isbn-3150"));
        logger.info("isbn-1234--" + simplBookRepository.findByIsbn("isbn-1234"));
        logger.info("BOOK取得処理終了");

        logger.info("BOOKテーブル取得処理開始");
        logger.info("isbn-1289" + tableBookRepository.findByIsbn("isbn-1289"));
        logger.info("isbn-1289" + tableBookRepository.findByIsbn("isbn-1289"));
        logger.info("isbn-4377" + tableBookRepository.findByIsbn("isbn-4377"));
        logger.info("isbn-6789" + tableBookRepository.findByIsbn("isbn-6789"));
        logger.info("isbn-1289" + tableBookRepository.findByIsbn("isbn-1289"));
        logger.info("isbn-1289" + tableBookRepository.findByIsbn("isbn-1289"));
        logger.info("isbn-1289" + tableBookRepository.findByIsbn("isbn-1289"));
        tableBookRepository.update("isbn-1289", "PHPCookBook");
        logger.warn("Changed : isbn-1289");
        logger.info("isbn-1289" + tableBookRepository.findByIsbn("isbn-1289"));
        logger.info("isbn-6789" + tableBookRepository.findByIsbn("isbn-6789"));
        logger.info("BOOKテーブル取得処理終了");
    }
}
