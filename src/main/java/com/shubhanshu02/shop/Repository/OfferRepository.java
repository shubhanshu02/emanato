package com.shubhanshu02.shop.Repository;

import java.sql.ResultSet;
import java.util.List;
import java.sql.SQLException;

import com.shubhanshu02.shop.Models.Offer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public class OfferRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private RowMapper<Offer> OfferRowMapper = new RowMapper<Offer>() {
        public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Offer offer = new Offer(rs.getString("offerCode"), rs.getDate("startDate"), rs.getDate("endDate"),
                    rs.getInt("discount"), rs.getInt("productId"), rs.getString("freebies"));
            return offer;
        }
    };

    public void save(Offer offer) {
        String query = "INSERT INTO Offer (startDate, endDate, discount, offerCode, freebies, productId) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(query, offer.getStartDate(), offer.getEndDate(), offer.getDiscount(), offer.getOfferCode(),
                offer.getFreebies(), offer.getProductId());
    }

    public List<Offer> getAllOffers() {
        String query = "SELECT * FROM Offer";
        return jdbcTemplate.query(query, OfferRowMapper);
    }

    public Offer getOfferByOfferCode(String offerCode) {
        String query = "SELECT * FROM Offer WHERE offerCode = ?";
        return jdbcTemplate.queryForObject(query, OfferRowMapper, offerCode);
    }

    public Offer getOfferByProductId(int productId) {
        String query = "SELECT * FROM Offer WHERE productId = ?";
        return jdbcTemplate.queryForObject(query, OfferRowMapper, productId);
    }

    public Boolean exists(String offerCode) {
        String query = "SELECT * FROM Offer WHERE offerCode = ?";
        return jdbcTemplate.query(query, OfferRowMapper, offerCode).size() > 0;
    }

    public Boolean delete(String offerCode) {
        String query = "DELETE FROM Offer WHERE offerCode = ?";
        return jdbcTemplate.update(query, offerCode) > 0;
    }
}
