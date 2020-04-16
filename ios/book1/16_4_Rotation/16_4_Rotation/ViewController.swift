//
//  ViewController.swift
//  16_4_Rotation
//
//  Created by estgames on 2017. 12. 13..
//  Copyright © 2017년 estgames. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var drgonfly: UIImageView!
    var lastRotation:CGFloat = 0.0      //마지막 회전각도
    
    @IBAction func rotateDragonfly(_ sender: UIRotationGestureRecognizer) {
        switch sender.state {   //제스처 상태
        case .began :   //제스처 시작
            sender.rotation = lastRotation
        case .changed : //제스처 중
            drgonfly.transform = CGAffineTransform(rotationAngle: sender.rotation)
        case .ended :
            lastRotation = sender.rotation
        default:
        break
        }
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

