package contracts.member

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("should return an appropriate member by memberId")
    name("should return an appropriate member by memberId") // generate 되는 테스트의 메소드명이 된다. verifyingReturnAMember

    request{
        method POST()

        headers {
            contentType 'application/json'
        }

        urlPath("/aggregate/member/find-member/query") { // url 보다 urlPath가 선호된다. test가 host independent 해지기 때문.
            body(
                    id: "-8396517434016664581"
            )
        }
    }
    response {
        status OK()
        body '''{ "name" : "SteveJobs", "address": {"city": "Seoul", "street": "Saimdang-Ro", "zipcode": "04422"} }'''

        headers {
            contentType('application/json')
        }
    }
}
