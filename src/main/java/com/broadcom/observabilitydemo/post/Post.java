package com.broadcom.observabilitydemo.post;

/**
 * @author Manoj Ramakrishnan (rmanoj@vmware.com).
 * @since 1/4/24 3:33 PM
 */
public record Post(Integer id, Integer userId, String title, String body) {
}
