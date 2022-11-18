/**
 * Object Structure
 * 
 * amount: 22465
 * date: "2022-02-27"
 * deals: 82
 * id: 37
 * sellerName: "Padme"
 * visited: 82
 */

export type Sale = {
    id: number;
    sellerName: string;
    visited: number
    deals: number;
    amount: number;
    date: string;
}