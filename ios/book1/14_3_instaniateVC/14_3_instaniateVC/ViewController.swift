//
//  ViewController.swift
//  14_3_instaniateVC
//
//  Created by estgames on 2017. 12. 12..
//  Copyright © 2017년 estgames. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBAction func gotoTreePage(_ sender: Any) {
        let nextVC = self.storyboard?.instantiateViewController(withIdentifier: "treePage") // 이동할 씬의 뷰 컨트롤러를 참조한다.
        nextVC?.modalTransitionStyle = .flipHorizontal  // 트랜지션 효과 변경
        
        present(nextVC!, animated: true, completion: nil)    //씬 이동
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

