import React from 'react';
import { FaHome, FaServicestack, FaInfoCircle, FaEnvelope } from 'react-icons/fa';

const SideBar = () => {
    return (
        <>
            <div className="sidebar">
                <div className="sidebar-logo">
                    <img src="../src/assets/lotus-icon.png" alt="" />
                </div>
                <div className="sidebar-container">
                    <ul>
                        <li>
                            <a href="#home">
                                <FaHome className="icon" /> <span className="text">Home</span>
                            </a>
                        </li>
                        <li>
                            <a href="#services">
                                <FaServicestack className="icon" /> <span className="text">Services</span>
                            </a>
                        </li>
                        <li>
                            <a href="#about">
                                <FaInfoCircle className="icon" /> <span className="text">About</span>
                            </a>
                        </li>
                        <li>
                            <a href="#contact">
                                <FaEnvelope className="icon" /> <span className="text">Contact</span>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </>
    );
};

export default SideBar;