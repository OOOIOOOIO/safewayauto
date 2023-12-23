package com.sch.shift3.user.service;

import com.sch.shift3.user.entity.ContentFeed;
import com.sch.shift3.user.repository.ContentFeedProductRepository;
import com.sch.shift3.user.repository.ContentFeedRepository;
import com.sch.shift3.user.repository.FeedRepository;
import com.sch.shift3.user.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FeedService {
    private final ProductRepository productRepository;
    private final ContentFeedProductRepository contentFeedProductRepository;
    private final ContentFeedRepository contentFeedRepository;
    private final FeedRepository feedRepository;

    public List<ContentFeed> getRecentFeed(){
        return feedRepository.getRecentFeed(3);
    }

    public List<ContentFeed> getFeedByCategory(String category){
        List<ContentFeed> feedByCategory = feedRepository.findTop3ByFeedCategory(category);
        feedByCategory.forEach(feed -> {
            String description = feed.getDescriptionNoHtml();
            if(description.length() > 50){
                description = description.substring(0, 47) + "...";
            }
            feed.setDescription(description);
        });
        return feedByCategory;
    }

    @Transactional
    public ContentFeed getFeedById(int id){
        return feedRepository.getFeedDetail(id);
    }

    public List<ContentFeed> getRelatedFeed(Integer productId) {
        return feedRepository.getRelatedFeed(productId);
    }

    public List<ContentFeed> getRelatedFeedByShopId(Integer shopId) {
        List<ContentFeed> feeds = feedRepository.getRelatedFeedByShopId(shopId);
        feeds.forEach(feed -> {
            String description = feed.getDescriptionNoHtml();
            if(description.length() > 15){
                description = description.substring(0, 12) + "...";
            }
            feed.setDescription(description);
        });

        return feeds;
    }

    public PageImpl<ContentFeed> searchFeed(String keyword, String category, Pageable pageable) {
        PageImpl<ContentFeed> feeds = feedRepository.searchFeed(keyword, category, pageable);
        feeds.getContent().forEach(feed -> {
            String description = feed.getDescriptionNoHtml();
            if(description.length() > 50){
                description = description.substring(0, 47) + "...";
            }
            feed.setDescription(description);
        });

        return feeds;
    }

    public List<ContentFeed> getResemblanceFeed(ContentFeed feed, int limit) {
        var feeds = contentFeedRepository.getResemblanceFeed(feed.getTitle(), feed.getId(), limit);
        feeds.forEach(feedItem -> {
            String description = feedItem.getDescriptionNoHtml();
            if(description.length() > 50){
                description = description.substring(0, 47) + "...";
            }
            feedItem.setDescription(description);
        });
        return feeds;
    }

    public List<ContentFeed> getBannerFeed() {

        List<ContentFeed> bannerFeed = feedRepository.getBannerFeed();

        String[] imgArr = new String[]{
        "https://seongho-s3-bucket.s3.ap-northeast-2.amazonaws.com/chicken/교촌치킨-레드콤보.jpeg",
        "https://seongho-s3-bucket.s3.ap-northeast-2.amazonaws.com/chicken/굽네치킨-고추바사삭.png",
        "https://seongho-s3-bucket.s3.ap-northeast-2.amazonaws.com/chicken/바른치킨-통곡물간장치킨.jpeg",
        "https://seongho-s3-bucket.s3.ap-northeast-2.amazonaws.com/chicken/bhc-뿌링클.jpg",
        "https://seongho-s3-bucket.s3.ap-northeast-2.amazonaws.com/chicken/bhc-포테킹-후라이드.jpeg",
        "https://seongho-s3-bucket.s3.ap-northeast-2.amazonaws.com/chicken/60계-크크크치킨.png",
        "https://seongho-s3-bucket.s3.ap-northeast-2.amazonaws.com/chicken/60계-간지치킨.png",
        "https://seongho-s3-bucket.s3.ap-northeast-2.amazonaws.com/chicken/60계-후라이드치킨.png"

        };
        for(int i = 0; i < bannerFeed.size(); i++){
            bannerFeed.get(i).updateBannerImg(imgArr[i]);

        }
        for(int i = 0; i < bannerFeed.size(); i++){
            log.info(bannerFeed.get(i).getThumbnailFileName());
        }
        log.info("================");

        return bannerFeed;
    }
}
