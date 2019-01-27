//
//  ViewController.swift
//  15_3_animate
//
//  Created by estgames on 2017. 12. 13..
//  Copyright © 2017년 estgames. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBAction func tabView(_ sender: UITapGestureRecognizer) {
        let flower = UIImageView(image: UIImage(named: "flower"))
        
        flower.alpha = 0    //투명도
        
        let scaleTransform = CGAffineTransform(scaleX: 0.2, y: 0.2) //크기 0.2배
        let rotationTransform = CGAffineTransform(rotationAngle: CGFloat(-M_PI_2))//-파이/2 회전한다.
        let transform = scaleTransform.concatenating(rotationTransform) //트랜스롬을 더해 합한다.
        flower.transform = transform    //flower를 변형시킨다.
        
        flower.center = sender.location(in: view)
        view.addSubview(flower)
        
        UIView.animate(withDuration: 1.0, delay: 0, options: [.curveEaseInOut], animations: {
            flower.alpha = 1.0
            flower.transform = .identity
        }, completion: nil)
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

