//
//  ControlViewController.swift
//  Alert
//
//  Created by estgames on 2017. 12. 21..
//  Copyright © 2017년 estgames. All rights reserved.
//

import UIKit

class ControlViewController: UIViewController {

    let slider = UISlider()
    
    var sliderValue: Float {
        return self.slider.value
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        
        self.slider.minimumValue = 0
        self.slider.maximumValue = 100
        
        self.slider.frame = CGRect(x: 0, y: 0, width: 170, height: 30)
        self.view.addSubview(self.slider)
        
        self.preferredContentSize = CGSize(width: self.slider.frame.width, height: self.slider.frame.height+10)
    }
}
