//
//  ViewController.swift
//  15_1_timer_car
//
//  Created by estgames on 2017. 12. 12..
//  Copyright © 2017년 estgames. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var car: UIImageView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.

        Timer.scheduledTimer(
            timeInterval: 0.1  //반복할 간격
            , target: self
            , selector: #selector(step)    //실행한 메서드
            , userInfo: nil
            , repeats: true)
    }

    @objc func step() {
        car.center.x += 10
        
        let carWidth = car.bounds.width
        if car.center.x > (view.bounds.width + carWidth/2) {
            car.center.x = -carWidth
            
            let viewH = view.bounds.height
            car.center.y = CGFloat(arc4random_uniform(UInt32(viewH)))
        }
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

