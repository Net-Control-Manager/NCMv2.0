package org.ncm.ncmv2.domain.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.ncm.ncmv2.domain.model.LatLong;
import org.ncm.ncmv2.domain.model.FCCStation;
import org.ncm.ncmv2.domain.model.Station;
import org.ncm.ncmv2.domain.model.TransientStation;
import org.springframework.stereotype.Repository;

@Repository("stationDao")
@Transactional
public class StationDaoImpl implements StationDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public TransientStation createTransientStation(String callsign) {
        TransientStation station = new TransientStation();

        return null;
    }

    @Override
    public <T extends Station> T getStationById(Long id) {
        Session session = entityManager.unwrap(org.hibernate.Session.class);

        Station station = null;

        // First, check if there's a real station by this ID
        String hql = "FROM FCCStation s WHERE s.id = :id";
        station = session.createQuery(hql, FCCStation.class)
                .setParameter("id", id)
                .setMaxResults(1)
                .getSingleResult();

        // If not, then check if there's a transient station by this ID
        if (station == null) {
            String t_hql = "FROM TransientStation s WHERE s.id = :id";
            station = session.createQuery(hql, TransientStation.class)
                    .setParameter("id", id)
                    .setMaxResults(1)
                    .getSingleResult();
        }

        return (T) station;
    }

    @Override
    public <T extends Station> T getStationByCallsign(String callsign) {
        Session session = entityManager.unwrap(org.hibernate.Session.class);

        Station station = null;

        // First, check if there's a real station by this callsign
        String hql = "FROM FCCStation s WHERE s.callsign = :callsign";
        station = session.createQuery(hql, FCCStation.class)
                .setParameter("callsign", callsign)
                .setMaxResults(1)
                .getSingleResult();

        // If not, then check if there's a transient station by this callsign
        if (station == null) {
            String t_hql = "FROM TransientStation s WHERE s.callsign = :callsign";
            station = session.createQuery(hql, TransientStation.class)
                    .setParameter("callsign", callsign)
                    .setMaxResults(1)
                    .getSingleResult();
        }

        return (T) station;
    }

    @Override
    public FCCStation updateStationFirstName(Long id, String firstName) {
        return null;
    }

    @Override
    public FCCStation updateStationLastName(Long id, String lastName) {
        return null;
    }

    @Override
    public FCCStation updateStationLatLong(Long id, LatLong latLong) {
        return null;
    }

    @Override
    public FCCStation updateStationW3W(Long id, String w3w) {
        return null;
    }

    @Override
    public FCCStation updateStationEmail(Long id, String email) {
        return null;
    }

    @Override
    public FCCStation updateStationPhone(Long id, String phone) {
        return null;
    }

    @Override
    public FCCStation updateStationCredentials(Long id, String credentials) {
        return null;
    }

    @Override
    public boolean permanentlyDeleteStation(Long id, String callsign) {
        return false;
    }
}
